package LinkedList;

import java.util.Scanner;

public class ReverseSubList {
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

        System.out.print("\nOriginal Linked List: ");
        display(head);

        System.out.print("Enter Starting position : ");
        int left = sc.nextInt();

        System.out.print("Enter Ending Positin : ");
        int right = sc.nextInt();

        if(left < 1 || right > n || left > right){
            System.out.print("Revrse Linked List Has Not Possible : ");
        }
        else{
            head = reverseBetween(head, left, right);
            System.out.print("After reversing sublist: ");
            display(head);
        }

        sc.close();
    }

    private static Node reverseBetween(Node head, int left, int right) {
        if(head == null || left == right){
            return head;
        }

        Node dummy = new Node(0);
        dummy.next = head;

        Node beforeLeft = dummy;
        for(int i=1; i<left; i++){
            beforeLeft = beforeLeft.next;
        }

        Node current = beforeLeft.next;
        for(int i=0; i<right-left; i++){

            Node moveNode = current.next;
            current.next = moveNode.next;
            moveNode.next = beforeLeft.next;
            beforeLeft.next = moveNode;

        }

        return dummy.next;
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
}
