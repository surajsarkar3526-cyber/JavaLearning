package LinkedList;

import java.util.Scanner;

public class InterSectionTwoLinkList {
    static class Node
    {
        int val;
        Node next;

        Node(int val){
            this.val = val;

        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Node head1 = null;
        Node head2 = null;
        Node commonNode = null;

        System.out.print("Enter Size of First ListNode : ");
        int n1 = sc.nextInt();

        System.out.print("Enter the Nodes Element : ");

        for(int i=0; i<n1; i++){

            int val = sc.nextInt();
            head1 = InsertAtTail(head1, val);

        }

        System.out.print("Enter Size of Second ListNode : ");
        int n2 = sc.nextInt();

        System.out.print("Enter the Nodes Element : ");

        for(int i=0; i<n2; i++){

            int val = sc.nextInt();
            head2 = InsertAtTail(head2, val);

        }

        System.out.print("Common Nodes Size : ");
        int commonSize = sc.nextInt();

        if(commonSize > 0){

            System.out.print("Enter CommonNodes : ");

            for(int i=0; i<commonSize; i++){
                int val = sc.nextInt();
                commonNode = InsertAtTail(commonNode,val);

            }

            head1 = ConnectCommonPart(head1, commonNode);
            head2 = ConnectCommonPart(head2, commonNode);

        }

        System.out.print("First ListNode : ");
        display(head1);

        System.out.print("Second ListNode : ");
        display(head2);

        Node answer = FindCommonNode(head1, head2);

        if(answer == null){
            System.out.println(
                    "Intersection doesn't Available! "
            );

        }
        else{
            System.out.println(
                    "IntersectionNode = "+answer.val
            );

        }

        sc.close();
    }

    private static Node FindCommonNode(Node head1, Node head2) {

        Node pointer1 = head1;
        Node pointer2 = head2;

        while(pointer1 != pointer2){

            if(pointer1 == null){
                pointer1 = head2;

            }
            else{
                pointer1 = pointer1.next;

            }

            if(pointer2 == null){
                pointer2 = head1;

            }
            else{
                pointer2 = pointer2.next;

            }
        }

        return pointer1;
    }

    private static void display(Node head) {
        Node temp = head;

        while(temp != null){
            System.out.print(temp.val+" ");

            if(temp.next != null){

                System.out.print("--> ");
            }

            temp = temp.next;

        }
        System.out.println();

    }

    private static Node ConnectCommonPart(Node head, Node commonNode) {

        if(head == null){
            return commonNode;

        }

        Node temp  = head;

        while(temp.next != null){
            temp = temp.next;

        }

        temp.next = commonNode;

        return head;

    }

    private static Node InsertAtTail(Node head, int val) {

        Node newNode = new Node(val);

        if(head == null){
            return newNode;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;

        }
        temp.next = newNode;

        return head;
    }
}
