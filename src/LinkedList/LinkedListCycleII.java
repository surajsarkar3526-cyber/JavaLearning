package LinkedList;

public class LinkedListCycleII {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        ListNode result = detectCycle(node1);
        if (result != null)
        {
            System.out.println("Cycle starts at node: " + result.val);
        }
        else
        {
            System.out.println("No cycle");
        }
    }
    private static ListNode detectCycle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow = node;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
