package LinkedList;

import java.util.Scanner;

public class CopyListWithRandomPointer {

    static class Node {

        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of Linked List: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("List is empty!");
            sc.close();
            return;
        }

        Node[] nodes = new Node[n];
        Node head = null;

        System.out.print("Enter Nodes: ");

        for (int i = 0; i < n; i++) {

            int val = sc.nextInt();
            head = insertAtTail(head, val);
        }

        Node current = head;

        for (int i = 0; i < n; i++) {
            nodes[i] = current;
            current = current.next;
        }

        System.out.println(
                "Enter random index for every node (-1 for null):"
        );

        for (int i = 0; i < n; i++) {

            System.out.print(
                    "Random index for node " + nodes[i].val + ": "
            );

            int randomIndex = sc.nextInt();

            if (randomIndex == -1) {
                nodes[i].random = null;

            }

            else if (randomIndex >= 0 && randomIndex < n) {
                nodes[i].random = nodes[randomIndex];

            }

            else {
                System.out.println(
                        "Invalid index! Random pointer set to null."
                );

                nodes[i].random = null;
            }
        }

        System.out.println("\nOriginal Linked List:");
        display(head);

        Node copiedHead = copyRandomList(head);

        System.out.println("\nCopied Linked List:");
        display(copiedHead);

        sc.close();
    }

    private static Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node current = head;

        while (current != null) {

            Node copyNode = new Node(current.val);

            copyNode.next = current.next;
            current.next = copyNode;

            current = copyNode.next;
        }

        current = head;

        while (current != null) {

            Node copyNode = current.next;

            if (current.random != null) {
                copyNode.random = current.random.next;
            }

            current = copyNode.next;
        }

        current = head;

        Node copiedHead = head.next;

        while (current != null) {

            Node copyNode = current.next;

            current.next = copyNode.next;

            if (copyNode.next != null) {
                copyNode.next = copyNode.next.next;
            }

            current = current.next;
        }

        return copiedHead;
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

        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = head;

        while (current != null) {

            System.out.print("Node: " + current.val);

            if (current.random != null) {
                System.out.print(
                        ", Random: " + current.random.val
                );
            }

            else {
                System.out.print(", Random: null");
            }

            System.out.println();

            current = current.next;
        }
    }
}
