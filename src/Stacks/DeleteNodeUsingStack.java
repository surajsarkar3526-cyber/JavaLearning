package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class DeleteNodeUsingStack {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of Linked List: ");
        int n = sc.nextInt();

        Node head = null;

        System.out.print("Enter Nodes: ");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            head = insertAtTail(head, val);
        }

        System.out.print("Original Linked List: ");
        display(head);

        System.out.print("Enter position to delete: ");
        int x = sc.nextInt();

        if (x < 1 || x > n) {
            System.out.println("Invalid position!");
        }

        else {
            head = deleteUsingStack(head, x);

            System.out.print("After deleting node: ");
            display(head);
        }

        sc.close();
    }

    private static Node deleteUsingStack(Node head, int x) {

        Stack<Node> stack = new Stack<>();

        Node current = head;
        int position = 1;

        while (current != null) {

            if (position != x) {
                stack.push(current);
            }

            current = current.next;
            position++;
        }

        Node newHead = null;

        while (!stack.isEmpty()) {

            Node node = stack.pop();

            node.next = newHead;
            newHead = node;
        }

        return newHead;
    }

    private static Node insertAtTail(Node head, int val) {

        Node newNode = new Node(val);

        if (head == null) {
            return newNode;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        return head;
    }

    private static void display(Node head) {

        Node current = head;

        while (current != null) {
            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }
}
