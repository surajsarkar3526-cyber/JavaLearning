package LinkedList;

import java.util.Scanner;

public class ReorderList {

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

        reorderList(head);
        System.out.println("Recorded Linked List : ");
        display(head);

        sc.close();

    }

    private static void reorderList(Node head) {

        if (head == null || head.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){

            slow = slow.next;
            fast = fast.next.next;

        }

        Node secondHead = slow.next;
        slow.next = null;

        Node secondhead = reverseList(secondHead);

        Node first = head;
        Node second = secondhead;

        while(second != null){

            Node firstNext = first.next;
            Node secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }

    }

    private static Node reverseList(Node head) {

        Node previous = null;
        Node current = head;

        while(current != null){

            Node newNode = current.next;
            current.next = previous;
            previous = current;

            current = newNode;

        }

        return previous;

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
