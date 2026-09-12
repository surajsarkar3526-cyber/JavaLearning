package LinkedList;

import java.util.Scanner;

public class SegregateEvenOdd {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Node head = null;

        System.out.print("Enter Size of Linked List: ");
        int n = sc.nextInt();

        System.out.print("Enter Nodes: ");

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            head = insertAtTail(head, val);
        }

        System.out.print("Original Linked List: ");
        display(head);

        Node result = segregateEvenOdd(head);

        System.out.print("After Segregating Even and Odd Nodes: ");
        display(result);

        sc.close();

    }

    private static Node segregateEvenOdd(Node head) {

        Node evenDummy = new Node(-1);
        Node oddDummy = new Node(-1);

        Node evenTail = evenDummy;
        Node oddTail = oddDummy;

        Node current = head;

        while(current != null){

            Node newNode = current.next;

            current.next = null;

            if(current.val % 2 == 0){
                evenTail.next = current;
                evenTail = current;

            }

            else{
                oddTail.next = current;
                oddTail = current;

            }

            current = newNode;

        }

        evenTail.next = oddDummy.next;

        return evenDummy.next;

    }

    private static void display(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val);

            if (temp.next != null) {
                System.out.print(" → ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    private static Node insertAtTail(Node head, int val) {

        Node newNode = new Node(val);

        if (head == null) {
            return newNode;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return head;
    }

}
