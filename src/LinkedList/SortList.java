package LinkedList;

import java.util.Scanner;

public class SortList {

    static class Node{

        int val;
        Node next;

        Node(int val){
            this.val = val;

        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Node head = null;

        System.out.print("Enter Size of Linked List : ");
        int n = sc.nextInt();

        System.out.print("Enter Nodes Element : ");

        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            head = InsertAtTail(head, val);

        }

        System.out.print("Original List : ");
        display(head);

        head = MergeSort(head);

        System.out.print("After Sorting List : ");
        display(head);

        sc.close();

    }

    private static void display(Node head) {

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

    private static Node MergeSort(Node head) {

        if(head == null || head.next == null){
            return head;

        }

        Node middle = findmiddleNodes(head);
        Node rightHead = middle.next;

        middle.next = null;

        Node left = MergeSort(head);
        Node right = MergeSort(rightHead);

        return MergeSortedLinkedList(left, right);

    }

    private static Node MergeSortedLinkedList(Node left, Node right) {

        Node dummy = new Node(-1);
        Node temp = dummy;

        while(left != null && right != null){

            if(left.val <= right.val){

                temp.next = left;
                left = left.next;

            }

            else{
                temp.next = right;
                right = right.next;

            }

            temp = temp.next;

        }

        if(left != null){
            temp.next = left;

        }

        if(right != null){
            temp.next = right;

        }

        return dummy.next;
    }

    private static Node findmiddleNodes(Node head) {

        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }

        return slow;

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

        return head;

    }
}
