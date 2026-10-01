package LinkedList;

public class ReverseLinkedListII {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int left = 2;
        int right = 4;
        System.out.println("Original List:");
        printList(head);
        head = reverseBetween(head, left, right);
        System.out.println("After Reversal:");
        printList(head);
    }

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i=1; i<left; i++){
            prev = prev.next;
        }
        ListNode current = prev.next;
        for(int i=0; i<right-left; i++){
            ListNode nextNode = current.next;
            current.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }
        return dummy.next;
    }

    private static void printList(ListNode head) {
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val+" ");
            if(temp.next != null){
                System.out.print("-> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
