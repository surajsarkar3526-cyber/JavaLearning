package LinkedList;

import java.util.Scanner;

class SwapLinkedList
{
    Node head;
    Node tail;
    int size = 0;
    public void insertAtTail(int val) {
        Node temp = new Node(val);
        if(head == null){
            head = tail = temp;
        }
        else{
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public void display() {
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void swapNodes(int k) {
        if(k <= 0 || k > size){
            throw new IllegalArgumentException("Invalid Index!");

        }

        Node first = head;
        for(int i=0; i<k; i++){
            first = first.next;
        }

        Node second = head;
        Node fast = first;

        while(fast.next != null){
            fast = fast.next;
            second = second.next;
        }

        int temp = second.val;
        second.val = fast.val;
        fast.val = temp;
    }
}
public class SwappingNodes {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        SwapLinkedList list = new SwapLinkedList();

        System.out.print("Enter number of nodes : ");
        int n = sc.nextInt();

        System.out.println("Enter node values :");

        for (int i = 0; i < n; i++) {
            list.insertAtTail(sc.nextInt());
        }

        System.out.print("Original List : ");
        list.display();

        System.out.print("Enter K : ");
        int k = sc.nextInt();

        try{
            list.swapNodes(k);

            System.out.print("List after swapping : ");
            list.display();

        }

        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
