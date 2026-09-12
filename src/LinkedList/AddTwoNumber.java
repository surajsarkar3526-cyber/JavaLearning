package LinkedList;

import java.util.Scanner;

public class AddTwoNumber {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.next = next;
        }
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of a Linked List : ");
        int n = sc.nextInt();
        Node head1 = null;
        System.out.println("Enter Nodes Elements in Linked List : ");
        for(int i=0; i<n; i++){
            head1 = InsertAtTail(head1, sc.nextInt());
        }
        System.out.print("Original Linked List : ");
        display(head1);

        System.out.print("Enter Second Size of Linked ;;list : ");
        int m = sc.nextInt();
        Node head2 = null;
        System.out.print("Enter Second Node Elements of Second Linked List : ");
        for(int j=0; j<m; j++){
            head2 = InsertAtTail(head2, sc.nextInt());
        }
        System.out.print("\nOriginal Linked List ");
        display(head2);
    }
    public static Node InsertAtTail(Node head, int val){
        Node newNode = new Node(val);
        if(head == null){
            return newNode;
        }
        Node temp = head;
        if(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }
    public static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val);
            if(temp.next != null){
                System.out.print("<->");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
