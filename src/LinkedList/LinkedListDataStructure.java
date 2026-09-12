package LinkedList;

import java.util.Scanner;

class LinkedList
{
    Node head; // null
    Node tail; // null
    int size = 0; // 0

    public void insertAtTail(int val) {

        Node temp = new Node(val);
        if(tail == null){
            head = tail = temp;
        }

        else{
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public void display() {

        if(head == null){
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void insertAtHead(int val) {
        Node temp = new Node(val);

        if(head == null){
            head = tail = temp;
        }

        else{
            temp.next = head;
            head = temp;
        }
        size++;
    }

    public void deleteAtHead() {
        if(head == null){
            System.out.print("ListNode is Empty! please Enter a Number ");
            return;
        }

        head = head.next;

        if(head == null){
            tail = null;
        }
        size--;
    }

    public int Search(int val) {

        if(head == null){
            return -1;
        }
        Node temp = head;
        int idx = 0;

        while(temp != null){
            if(temp.val == val){
                return idx;
            }
            temp = temp.next;
            idx++;
        }

        return -1;
    }

    public void InsertAtMiddle(int val, int idx) {

        if(idx < 0 || idx > size){
            System.out.print("Invalid Index! ");
        }

        else if(idx == 0){
            insertAtHead(val);
        }

        else if(idx == size){
            insertAtTail(val);
        }

        else{
            Node temp = head;
            for(int i=1; i<=idx-1; i++){
                temp = temp.next;
            }

            Node t = new Node(val);
            t.next = temp.next;
            temp.next = t;
            size++;
        }
    }

    public int get(int idx) {
        Node temp = head;
        for(int i=1; i<idx; i++){
            temp = temp.next;
        }

        return temp.val;
    }

    public void delete(int idx) {

        if(idx < 0 || idx >= size){
            System.out.print("Invalid Index! ");
            return;
        }

        if(idx == 0){
            deleteAtHead();
            return;
        }

        Node temp = head;
        for(int i=1; i<=idx-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;

        if(idx == size-1){
            tail = temp;
        }
        size--;
    }

    public int SearchAtMiddle() {

//        int length = 0;
//        Node temp = head;
//
//        while(temp != null){
//            temp = temp.next;
//            length++;
//        }
//
//        temp = head;
//        for(int i=1; i<=length/2; i++){
//            temp = temp.next;
//        }
//
//        return temp.val;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.val;

    }

    public void deleteAtMiddle() {
        if (head == null) {
            System.out.println("Empty List!");
            ;
            return;
        }

        if (head.next == null) {


            head = null;
            tail = null;
            size--;
            return;
        }

        Node slow = head;
        Node fast = head;
        Node previous = head;

        while (fast != null && fast.next == null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        previous.next = slow.next;

        if(slow == tail){
            tail = previous;
        }

        size--;
    }
}
public class LinkedListDataStructure {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        LinkedList ll = new LinkedList();
        ll.insertAtTail(10);
        ll.display();

        ll.insertAtTail(20);
        ll.display();

        ll.insertAtTail(30);
        ll.display();

        ll.insertAtTail(40);
        ll.display();

        ll.insertAtHead(50);
        ll.display();

        ll.insertAtHead(89);
        ll.display();

        ll.insertAtHead(98);
        ll.display();

        ll.deleteAtHead();
        ll.display();

        System.out.println("Size of ListNode : "+ll.size);
        System.out.println(ll.Search(50));

        ll.InsertAtMiddle(45,2);
        ll.display();

        ll.get(2);
        ll.display();
        System.out.println("Size of ListNode : "+ll.size);

        ll.delete(3);
        ll.display();

        System.out.println(ll.SearchAtMiddle());

        ll.deleteAtMiddle();
        ll.display();
    }
}
