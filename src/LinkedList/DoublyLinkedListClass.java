package LinkedList;

public class DoublyLinkedListClass {

    static class ListNode {

        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;

        }
    }

    ListNode head;
    ListNode tail;
    int size = 0;

    public static void main(String[] args){

        DoublyLinkedListClass list = new DoublyLinkedListClass();

        list.insertAtHead(20);
        list.insertAtHead(10);

        list.insertAtTail(30);
        list.insertAtTail(40);

        System.out.print("Forward List: ");
        list.displayForward();

        System.out.print("Reverse List: ");
        list.displayReverse();

        list.deleteAtHead();
        list.Insert(2,5);

        System.out.print("\nAfter Delete at Head: ");
        list.displayForward();

        list.deleteAtTail();

        System.out.print("After Delete at Tail: ");
        list.displayForward();

    }

    private void Insert(int idx, int val) {
        if(idx < 1 || idx > size){
            System.out.print("Invalid Index!");
            return;
        }
        if(idx == size){
            insertAtTail(val);
            return;

        }
        ListNode a = new ListNode(val);
        ListNode temp = head;
        for(int i=1; i<=idx-1; i++){
            temp = temp.next;

        }
        a.prev = temp;
        a.next = temp.next;
        temp.next = a;
        a.next.prev = a;
        size++;
    }

    private void deleteAtTail() {
        if(head==null){
            System.out.print("Empty List!");
            return;

        }
        if(head == tail){
            head = null;
            tail = null;
        }
        else{
            tail = tail.prev;
            tail.next = null;

        }
        size--;
    }

    private void deleteAtHead() {

        if(head == null){
            System.out.print("Empty List!");
            return;
        }
        if(head == tail){
            head = null;
            tail = null;

        }
        else{
            head = head.next;
            head.prev = null;

        }
        size--;
    }

    private void displayReverse() {

        if(tail == null){
            System.out.print("Empty List!");
            return;

        }

        ListNode temp = tail;
        while(temp != null){
            System.out.print(temp.val);
            if(temp.prev != null){
                System.out.print(" <-> ");

            }
            temp = temp.prev;
        }
        System.out.println();
    }

    private void displayForward() {

        if(head == null){
            System.out.print("Empty List!");
            return;

        }
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val);
            if(temp.next != null){
                System.out.print(" <-> ");

            }
            temp = temp.next;
        }
        System.out.println();
    }

    private void insertAtTail(int val) {

        ListNode newNode = new ListNode(val);
        if(head == null){
            head = newNode;

        }

        else{
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;

        size++;
    }

    private void insertAtHead(int val) {

        ListNode newNode = new ListNode(val);
        if(head == null){
            head = newNode;
            tail = newNode;
        }

        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;

    }
}
