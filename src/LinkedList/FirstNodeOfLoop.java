package LinkedList;

import java.util.Scanner;

public class FirstNodeOfLoop {

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

    static Node findFirstNodeOfLoop(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Node head = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.print("Enter node values: ");

        for (int i = 0; i < n; i++) {
            head = insertAtTail(head, sc.nextInt());
        }

        System.out.print("Enter loop starting position (0 for no loop): ");
        int position = sc.nextInt();

        if (position > 0 && position <= n) {

            Node loopStart = head;
            Node tail = head;

            for (int i = 1; i < position; i++) {
                loopStart = loopStart.next;
            }

            while (tail.next != null) {
                tail = tail.next;
            }

            tail.next = loopStart;
        }

        Node firstLoopNode = findFirstNodeOfLoop(head);

        if (firstLoopNode != null) {
            System.out.println(
                    "First node of loop: " + firstLoopNode.val
            );

        }
        else {
            System.out.println("Loop does not exist.");

        }

        sc.close();
    }
}
