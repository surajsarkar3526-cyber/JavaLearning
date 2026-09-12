package LinkedList;

import java.util.Scanner;

public class MergeKSortedLinkedLists {

    static class Node {

        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter No. of Linked Lists: ");
        int k = sc.nextInt();

        Node[] list = new Node[k];

        for (int i = 0; i < k; i++) {

            System.out.print(
                    "Enter No. of Nodes in Linked List "
                            + (i + 1) + ": "
            );
            int n = sc.nextInt();

            System.out.print(
                    "Enter Sorted Nodes of Linked List "
                            + (i + 1) + ": "
            );

            for (int j = 0; j < n; j++) {

                int val = sc.nextInt();

                list[i] = insertAtTail(list[i], val);
            }
        }

        System.out.println("\nOriginal Linked Lists:");

        for (int i = 0; i < k; i++) {

            System.out.print("List " + (i + 1) + ": ");
            display(list[i]);
        }

        Node result = mergeKSortedLists(list);

        System.out.print("\nMerged Sorted Linked List: ");
        display(result);

        sc.close();
    }

    private static Node mergeKSortedLists(Node[] list) {

        if (list == null || list.length == 0) {
            return null;
        }

        Node result = null;

        for (int i = 0; i < list.length; i++) {

            result = mergeTwoSortedLists(result, list[i]);
        }

        return result;
    }

    private static Node mergeTwoSortedLists(
            Node result, Node currentList) {

        Node dummy = new Node(-1);
        Node temp = dummy;

        while (result != null && currentList != null) {

            if (result.val <= currentList.val) {

                temp.next = result;
                result = result.next;

            }
            else {

                temp.next = currentList;
                currentList = currentList.next;
            }

            temp = temp.next;
        }

        if (result != null) {
            temp.next = result;
        }
        else {
            temp.next = currentList;
        }

        return dummy.next;
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
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }
}
