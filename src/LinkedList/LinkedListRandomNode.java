package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode {
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
        LinkedListRandomNode solution = new LinkedListRandomNode(head);
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
    }

    private int getRandom() {
        int index = random.nextInt(values.size());
        return values.get(index);
    }
    private final List<Integer> values;
    private final Random random;
    public LinkedListRandomNode(ListNode head) {
        values = new ArrayList<>();
        random = new Random();
        ListNode current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
    }
}
