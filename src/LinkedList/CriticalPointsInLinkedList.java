package LinkedList;

import java.util.Arrays;
import java.util.Scanner;

public class CriticalPointsInLinkedList {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Size of Linked List: ");
        int n = sc.nextInt();

        Node head = null;

        System.out.print("Enter Nodes: ");

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            head = insertAtTail(head, val);
        }

        System.out.print("Original Linked List: ");
        display(head);

        int[] result = nodesBetweenCriticalPoints(head);

        System.out.println("Minimum and Maximum Distance: "
                + Arrays.toString(result));

        sc.close();
    }

    private static int[] nodesBetweenCriticalPoints(Node head) {

        if (head == null || head.next == null ||
                head.next.next == null) {
            return new int[]{-1, -1};
        }

        Node previous = head;
        Node current = head.next;

        int position = 1;

        int firstCritical = -1;
        int previousCritical = -1;

        int minimumDistance = Integer.MAX_VALUE;
        int maximumDistance = -1;

        while (current.next != null) {

            Node nextNode = current.next;

            boolean isLocalMaximum =
                    current.val > previous.val &&
                            current.val > nextNode.val;

            boolean isLocalMinimum =
                    current.val < previous.val &&
                            current.val < nextNode.val;

            if (isLocalMaximum || isLocalMinimum) {

                if (firstCritical == -1) {
                    firstCritical = position;
                }

                else {
                    int distance = position - previousCritical;

                    minimumDistance =
                            Math.min(minimumDistance, distance);

                    maximumDistance =
                            position - firstCritical;
                }

                previousCritical = position;
            }

            previous = current;
            current = current.next;
            position++;
        }

        // दो से कम critical points मिले
        if (maximumDistance == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{minimumDistance, maximumDistance};
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
}
