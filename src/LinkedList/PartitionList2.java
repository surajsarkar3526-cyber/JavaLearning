package LinkedList;

import java.util.Scanner;

public class PartitionList2 {

    static class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;

        }

    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        Node head = null;

        System.out.print("Enter Size of Linked List : ");
        int n = sc.nextInt();

        System.out.print("Enter Nodes : ");

        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            head = InsertAtTail(head,val);

        }

        System.out.print("Original Linked List : ");
        display(head);

        System.out.print("Enter Value of X : ");
        int x =sc.nextInt();

        Node result = Mergepartions(head, x);

        System.out.print("Linked List After Partition : ");
        display(result);

        sc.close();

    }

    private static Node Mergepartions(Node head, int x) {

        Node lessDummy = new Node(0);
        Node equalDummy = new Node(0);
        Node greaterDummy = new Node(0);

        Node lessTail = lessDummy;
        Node equalTail = equalDummy;
        Node greaterTail = greaterDummy;

        Node current = head;

        while (current != null) {

            Node nextNode = current.next;

            current.next = null;

            if (current.val < x) {
                lessTail.next = current;
                lessTail = current;

            }
            else if (current.val == x) {
                equalTail.next = current;
                equalTail = current;

            } else {
                greaterTail.next = current;
                greaterTail = current;
            }

            current = nextNode;
        }

        lessTail.next = equalDummy.next;

        equalTail.next = greaterDummy.next;



        if (lessDummy.next != null) {
            return lessDummy.next;
        }

        if (equalDummy.next != null) {
            return equalDummy.next;
        }

        return greaterDummy.next;
    }

    private static Node InsertAtTail(Node head, int val) {

        Node newNode = new Node(val);
        if(head == null){
            return newNode;

        }

        Node temp = head;
        while(temp.next !=null){
            temp = temp.next;

        }
        temp.next = newNode;

        return head;

    }

    private static void display(Node head) {
        Node temp = head;

        while(temp != null){
            System.out.print(temp.val+" ");

            if(temp.next != null){
                System.out.print("-> ");

            }
            temp = temp.next;

        }
        System.out.println();

    }
}
