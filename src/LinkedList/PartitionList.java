package LinkedList;

import java.util.Scanner;

public class PartitionList {

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
            head = InsertAtTail(head, val);

        }

        System.out.print("Original Linked List : ");
        display(head);

        System.out.print("Enter Value of X : ");
        int x =sc.nextInt();

        Node result = Mergepartion(head, x);

        System.out.print("Linked List After Partition : ");
        display(result);

        sc.close();
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

    private static Node Mergepartion(Node head, int x) {

        Node smallDummy = new Node(0);
        Node smallTail = smallDummy;

        Node largeDummy = new Node(0);
        Node largeTail = largeDummy;

        Node current = head;

        while(current != null){

            if(current.val < x){
                smallTail.next = current;
                smallTail = smallTail.next;

            }

            else{
                largeTail.next = current;
                largeTail = largeTail.next;

            }
            current = current.next;

        }

        largeTail.next = null;

        smallTail.next = largeDummy.next;

        return smallDummy.next;

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

}
