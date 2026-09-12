package LinkedList;

import java.util.Scanner;

class Node{
    int val;
    Node next;
    Node(){

    }
    Node(int val){
        this.val = val;
    }
}
public class NodeOfLinkedList {
    public static void printRec(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.val+" ");
        printRec(head.next);
    }

    public static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 10->20->30->40->50
        Node a = new Node(sc.nextInt());  // StringBuilders st = new StringBuilders(sc.nextInt());
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50);

        a.next = b; b.next = c; c.next = d; d.next = e;
        print(a);
        printRec(a);
//        System.out.println(a.val);
//        System.out.println(a.next);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(a.next.next);
//        System.out.println(d);
//        System.out.println(a.next.next.next);
//        System.out.println(e);
//        System.out.println(a.next.next.next.next);
    }
}
