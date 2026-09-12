package LinkedList;

import java.util.Scanner;

public class MaximumTwinSum {

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

        int result = maximumTwinSum(head);
        System.out.println("Maximum Twin Sum: " + result);

        sc.close();

    }

    private static int maximumTwinSum(Node head) {

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){

            slow = slow.next;
            fast = fast.next.next;

        }

        Node SecondHalf = reverseList(slow.next);
        int MaximumSum = Integer.MIN_VALUE;

        Node first = head;
        Node second = SecondHalf;

        while(second != null){

            int TwinSum = first.val + second.val;
            MaximumSum = Math.max(MaximumSum, TwinSum);

            first = first.next;
            second = second.next;

        }

        return MaximumSum;

    }

    private static Node reverseList(Node val) {

        Node previous = null;
        Node current = val;

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
