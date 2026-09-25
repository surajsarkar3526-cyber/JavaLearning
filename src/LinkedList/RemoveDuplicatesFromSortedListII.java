package LinkedList;

public class RemoveDuplicatesFromSortedListII {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val =  val;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        ListNode result = deleteDuplicates(head);
        printList(result);
    }

    private static void printList(ListNode root) {
        ListNode temp = root;
        while(temp != null){
            System.out.print(temp.val);
            if(temp.next != null){
                System.out.print("<->");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null){
            if(curr.next != null && curr.val == curr.next.val){
                while(curr.next != null && curr.val == curr.next.val){
                    curr = curr.next;
                }
                prev.next = curr.next;
            }
            else{
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
