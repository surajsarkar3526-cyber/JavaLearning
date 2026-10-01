package LinkedList;

public class SwappingNodesInLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode swapNodes(ListNode head, int k) {
        int n = 0;
        ListNode current = head;
        while (current != null) {
            n++;
            current = current.next;
        }
        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        ListNode second = head;
        int positionFromBeginning = n - k + 1;
        for (int i = 1; i < positionFromBeginning; i++) {
            second = second.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        head = swapNodes(head, k);
        printList(head);
    }
}
