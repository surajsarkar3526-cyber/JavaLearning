package LinkedList;

import java.util.Scanner;

class KthElement
{
    Node head;
    Node tail;
    int size = 0;

    KthElement(){

    }

    public void InsertAtTail(int val) {

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
            System.out.println(temp.val+" ");
            temp = temp.next;
        }

        System.out.println();
    }

    public int KthFromEnd(int k) {

        if(k <= 0 || k > size){
            throw new IllegalArgumentException("Invalid Index!");

        }

        Node slow = head;
        Node fast = head;

        for(int i=0; i<k; i++){
            if(fast == null){
                return -1;
            }
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;

        }
        return slow.val;
    }

}

public class KthFromEnd {

    public static void main(String[] args){
        KthElement ll = new KthElement();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No. of Node : ");
        int n = sc.nextInt();

        System.out.println("Enter Node Elements : ");

        for(int i = 0; i<n; i++){
            ll.InsertAtTail(sc.nextInt());
        }

        System.out.println("Display the Numbers : ");
        ll.display();

        System.out.println("Enter Index which once you want's to Remove : ");
        int k = sc.nextInt();

        try{
            int answer = ll.KthFromEnd(k);
            System.out.println(k+"th index of Kth Index Is : "+answer);
        }

        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        sc.close();

    }

}
