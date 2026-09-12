package LinkedList;

import java.util.Scanner;

public class FloydCycleDetectionAlgorithm {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    static Node insertAtTail(Node head, int val) {

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

    static boolean hasLoop(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;       // 1 step
            fast = fast.next.next;  // 2 steps

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Node head = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter node values:");

        for (int i = 0; i < n; i++) {
            head = insertAtTail(head, sc.nextInt());
        }

        // Testing के लिए last node को second node से जोड़ना
        if (head != null && head.next != null) {

            Node last = head;

            while (last.next != null) {
                last = last.next;
            }

            last.next = head.next; // Loop created
        }

        if (hasLoop(head)) {
            System.out.println("Loop is present");
        } else {
            System.out.println("Loop is not present");
        }

        sc.close();

    }
}
