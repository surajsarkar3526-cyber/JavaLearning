package LinkedList;

import java.util.Scanner;

public class RemoveDuplicatesSortedDLL {

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

        head = removeDuplicates(head);
        System.out.print("\nForward Doubly Linked List : ");
        display(head);

        sc.close();

    }

    private static Node removeDuplicates(Node head) {
        if(head == null || head.next == null){
            return head;

        }

        Node current = head;
        while(current.next != null){

            if(current.val == current.next.val) {
                Node duplicate = current.next;
                current.next = duplicate.next;

                if (duplicate.next != null) {
                    duplicate.next.prev = current;
                }
                duplicate.next = null;
                duplicate.prev = null;

            }
            else{
                current = current.next;
            }
        }
        return head;
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
