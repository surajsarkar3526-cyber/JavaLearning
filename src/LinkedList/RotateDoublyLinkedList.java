package LinkedList;

import java.util.Scanner;

public class RotateDoublyLinkedList {

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
        display(head);

        System.out.print("Enter k : ");
        int k = sc.nextInt();

        head = rotateList(head, k);
        System.out.print("\nForward Doubly Linked List : ");
        display(head);

        sc.close();

    }

    private static Node rotateList(Node head, int k) {

        if(head == null || head.next == null || k == 0){
            return head;
        }

        Node tail = head;
        int len = 0;
        while(tail.next != null){
            tail = tail.next;
            len++;

        }
        Node current = head;
        k = len % k;

        for(int i= 1; i<k; i++){
            current = current.next;
            len++;
        }

        Node newNode = current.next;

        tail.next = head;
        current.next = null;
        newNode.prev = null;

        return newNode;
    }

    private static void display(Node head) {
        if(head == null){
            System.out.print("Empty List!");
            return;
        }

        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val);
            if(temp.next!=null){
                System.out.print(" ⇄ ");
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
