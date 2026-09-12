package LinkedList;

import java.util.Scanner;

public class ReverseDoublyLinkedList{

    static class Node{

        int val;
        Node next;
        Node prev;

        Node(int val){
            this.val = val;

        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Size of Linked List : ");
        int n = sc.nextInt();

        Node head = null;
        System.out.print("Enter Nodes : ");
        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            head = InsertAtTail(head, val);
        }

        System.out.print("\nOriginal Doubly Linked List : ");
        displayForward(head);

        head = reverseList(head);
        System.out.print("\nForward Doubly Linked List : ");
        displayForward(head);

        System.out.print("\nBackWard Doubly Linked List : ");
        displayBackWard(head);
    }

    private static void displayBackWard(Node head) {
        if(head == null){
            System.out.print("Empty List!");
            return;

        }
        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        while(temp != null){
            System.out.print(temp.val);
            if(temp.prev != null){
                System.out.print(" <-> ");
            }
            temp = temp.prev;
        }
        System.out.println();
    }

    private static Node reverseList(Node head) {
        Node current = head;
        Node newNode = null;
        while(current != null){
            Node temp = current.next;
            current.next = current.prev;
            current.prev = temp;

            newNode = current;

            current = current.prev;
        }
        return newNode;
    }

    private static void displayForward(Node head) {
        if(head == null){
            System.out.print("Empty List!");
            return;
        }

        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val);
            if(temp.next!=null){
                System.out.print(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node InsertAtTail(Node head, int val) {
        Node newNode = new Node(val);

        if(head == null){
            return newNode;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;

        }
        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }
}
