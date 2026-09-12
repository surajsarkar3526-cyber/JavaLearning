package LinkedList;

import java.util.Scanner;

public class CircularLinkedListTraversal {

    static class Node{

        int val;
        Node next;

        Node(int val){
            this.val = val;

        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size Of Linked List : ");
        int n = sc.nextInt();

        Node head = null;

        System.out.print("Enter Nodes : ");
        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            head = InsertAtTail(head, val);

        }

        System.out.print("Circular Linked List : ");
        display(head);

        sc.close();
    }

    private static void display(Node head) {
        if(head == null){
            System.out.print("List is Empty!");
            return;
        }

        Node temp = head;
        do{
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        while(temp != head);

        System.out.println("(back to head)");
    }

    private static Node InsertAtTail(Node head, int val) {

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
