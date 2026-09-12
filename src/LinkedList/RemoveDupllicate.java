package LinkedList;

import java.util.Scanner;

public class RemoveDupllicate {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Size of Nodes : ");
        int n = sc.nextInt();

        Node Head = null;

        System.out.print("Enter Nodes Element : ");

        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            Head = InsertAtTail(Head, val);
        }

        System.out.print("Original List : ");
        Display(Head);

        Node result = removedupllicate(Head);

        System.out.print("After removing duplicates: ");
        Display(result);

        sc.close();
    }

    private static Node removedupllicate(Node head) {

        Node current = head;

        while(current != null && current.next != null){

            if(current.val == current.next.val){
                current.next = current.next.next;

            }

            else{

                current = current.next;
            }
        }

        return head;
    }

    private static void Display(Node head) {

        Node temp = head;

        while(temp != null){

            System.out.print(temp.val+" ");

            if(temp.next != null){

                System.out.print("-> ");
            }

            temp = temp.next;

        }
        System.out.println();

    }

    private static Node InsertAtTail(Node Head, int val) {

        Node newNode = new Node(val);

        if(Head == null){
            return newNode;
        }

        Node temp = Head;

        while(temp.next != null){
            temp = temp.next;

        }

        temp.next = newNode;

        return Head;
    }
}
