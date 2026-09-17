package LinkedList;

public class ReverseNodesKGroup {
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
        int k = 2;
        ListNode result = reverseKGroup(head, k);
        printList(result);
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode groupPrev = dummy;
        while(true){
            ListNode kth = groupPrev;
            for(int i=0; i<k; i++){
                kth = kth.next;
                if(kth == null){
                    return dummy.next;
                }
            }
            ListNode groupNext = kth.next;
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            while(curr != groupNext){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }
    }

    private static void printList(ListNode result) {
        ListNode temp = result;
        while(temp != null){
            System.out.print(temp.val);
            if(temp.next != null){
                System.out.print(" --> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
