package MergeSort;

public class MergeKSortedLists {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = createList(new int[]{1, 4, 5});
        ListNode list2 = createList(new int[]{1, 3, 4});
        ListNode list3 = createList(new int[]{2, 6});
        ListNode[] lists = {list1, list2, list3};
        ListNode result = mergeKLists(lists);
        System.out.println("Merged Sorted List:");
        printList(result);
    }

    private static void printList(ListNode head) {
        while(head != null){
            System.out.print(head.val+" ");
            while(head.next != null){
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        return divide(lists, 0, lists.length - 1);
    }

    private static ListNode divide(ListNode[] lists, int left, int right) {
        if(left == right){
            return lists[left];
        }
        int mid = left + (right - left)/2;
        ListNode leftList = divide(lists, left, mid);
        ListNode rightList = divide(lists,mid + 1, right);
        return mergeTwoLists(leftList, rightList);
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

    private static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for(int ele : arr){
            current.next = new ListNode(ele);
            current = current.next;
        }
        return dummy.next;
    }
}
