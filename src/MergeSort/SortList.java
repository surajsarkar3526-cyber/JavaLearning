package MergeSort;

public class SortList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        System.out.println("Before Sorting:");
        printList(head);
        head = sortList(head);
        System.out.println("After Sorting:");
        printList(head);
    }

    private static void printList(ListNode head) {
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val);
            if(temp.next != null){
                System.out.print("->");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    private static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return merge(left,right);
    }

    private static ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            }
            else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        }
        else {
            current.next = list2;
        }
        return dummy.next;
    }
}
