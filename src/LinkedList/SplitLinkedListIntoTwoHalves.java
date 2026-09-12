package LinkedList;

import java.util.Scanner;

public class SplitLinkedListIntoTwoHalves {

    static class Node{

        int val;
        Node next;

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

        System.out.print("\nOriginal Linked List : ");
        display(head);

        Node[] halves = splitList(head);

        System.out.print("First Halves : ");
        display(halves[0]);

        System.out.print("\nSecond Halves : ");
        display(halves[1]);

        sc.close();
    }

    private static Node[] splitList(Node head) {
        if(head == null){
            return new Node[]{null, null};
        }
        if(head.next == null){
            return new Node[]{head, null};

        }

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }
        Node secondHead = slow.next;
        slow.next = null;

        return new Node[]{head, secondHead};
    }

    private static void display(Node head) {
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val+" ");
            if(temp.next != null){
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node InsertAtTail(Node head, int val) {
        Node newNode = new Node(val);
        if(head==null){
            return newNode;

        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;

        }
        temp.next = newNode;
        return head;
    }
}
