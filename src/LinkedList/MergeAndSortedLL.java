package LinkedList;

import java.util.Scanner;

public class MergeAndSortedLL {

    static class Node{
        int val;
        Node next;

        Node(int val){

            this.val = val;

        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Node Head1 = null;
        Node Head2 = null;

        System.out.print("Enter First Size Of List ; ");

        int n1 = sc.nextInt();

        System.out.print("Enter First List Of Nodes : ");

        for(int i=0; i<n1; i++){
            int val = sc.nextInt();
            Head1 = InserAtTail(Head1, val);

        }

        System.out.print("First Linked List : ");
        display(Head1);

        System.out.print("Enter Size of Second Linked List : ");
        int n2 = sc.nextInt();

        System.out.print("Enter Second list Of Nodes : ");

        for(int i=0; i<n2; i++){
            int val = sc.nextInt();
            Head2 = InserAtTail(Head2, val);

        }

        System.out.print("Secomd Linked List : ");
        display(Head2);

        Node Merge = MergeSortedForm(Head1, Head2);

        System.out.print("MergeLinked List is : ");
        display(Merge);

        sc.close();
    }

    private static Node MergeSortedForm(Node head1, Node head2) {

        Node dummy = new Node(-1);
        Node temp = dummy;

        while(head1 != null && head2 != null){

            if(head1.val <= head2.val){

                temp.next = head1;
                head1 = head1.next;

            }

            else{

                temp.next = head2;
                head2 = head2.next;

            }

            temp = temp.next;
        }

        if(head1 != null){
            temp.next = head1;

        }

        if(head2 != null){
            temp.next = head2;

        }

        return dummy.next;
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

    private static Node InserAtTail(Node head, int val) {

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