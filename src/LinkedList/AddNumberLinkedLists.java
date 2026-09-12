package LinkedList;

import java.util.Scanner;

public class AddNumberLinkedLists {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Node head1 = null;
        Node head2 = null;

        System.out.print("Enter size of first linked list: ");
        int n1 = sc.nextInt();

        System.out.print("Enter digits of first linked list: ");
        for (int i = 0; i < n1; i++) {
            head1 = insertAtTail(head1, sc.nextInt());
        }

        System.out.print("Enter size of second linked list: ");
        int n2 = sc.nextInt();

        System.out.print("Enter digits of second linked list: ");
        for (int i = 0; i < n2; i++) {
            head2 = insertAtTail(head2, sc.nextInt());
        }

        System.out.print("\nFirst Linked List: ");
        display(head1);

        System.out.print("Second Linked List: ");
        display(head2);

        Node result = addTwoNumbers(head1, head2);
        System.out.print("Result Linked List : ");
        display(result);
        sc.close();
    }

    private static Node addTwoNumbers(Node head1, Node head2) {

        Node dummy = new Node(0);
        Node tail = dummy;

        Node first = head1;
        Node second = head2;

        int carry = 0;

        while (first != null || second != null || carry != 0) {

            int firstValue = 0;
            int secondValue = 0;

            if (first != null) {
                firstValue = first.val;
                first = first.next;
            }

            if (second != null) {
                secondValue = second.val;
                second = second.next;
            }

            int sum = firstValue + secondValue + carry;

            int digit = sum % 10;
            carry = sum / 10;

            tail.next = new Node(digit);
            tail = tail.next;
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
