package LinkedList;
import java.util.Scanner;

public class DeleteAndReverseCircularLinkedList {

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

        System.out.print("Enter Deleting Node : ");
        int deleteNode = sc.nextInt();

        head = deleteNode(head, deleteNode);
        System.out.print("\nAfter Deleting Node : ");
        display(head);

        head = reverseList(head);
        System.out.print("Reverse Linked List : ");
        display(head);


        sc.close();

    }

    private static Node deleteNode(Node head, int value) {
        if(head == null){
            System.out.print("Empty Linked List : ");
            return null;
        }
        if(head.val == value) {

            if (head.next == head) {
                return head;
            }

            Node last = head;
            while (last.next != head) {
                last = last.next;
            }

            head = head.next;
            last.next = head;

            return head;
        }
        Node current = head;

        while(current.next != head && current.next.val != value){
            current = current.next;

        }

        if(current.next == head){
            System.out.print("Value Not Found!");
            return head;
        }

        current.next = current.next.next;

        return head;
    }

    private static Node reverseList(Node head) {

        if(head == null || head.next == null){
            return head;

        }

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

        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.val + " -> ");
            temp = temp.next;

        } while (temp != head);

        System.out.println("(back to head)");
    }

    private static Node insertAtTail(Node head, int val) {
        Node newNode = new Node(val);
        if(head == null){
            newNode.next = newNode;
            return newNode;

        }

        Node temp = head;
        while(temp.next != head){
            temp = temp.next;

        }
        temp.next = newNode;
        newNode.next = head;

        return head;
    }

}
