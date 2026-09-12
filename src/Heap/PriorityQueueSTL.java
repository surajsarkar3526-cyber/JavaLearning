package Heap;

import java.util.PriorityQueue;

public class PriorityQueueSTL {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10); pq.add(20); pq.add(-30);
        System.out.println(pq.peek());  // 0(1) -> T.C
        pq.add(-35);
        System.out.println(pq.peek());  // 0(1) -> T.C
        System.out.println(pq.size());
        System.out.println(pq.remove());
        System.out.println(pq.peek());
        System.out.println(pq);   //0(n)  -> T.C

        pq.add(5); pq.add(8); pq.add(2); pq.add(0);
        pq.add(3); pq.add(1); pq.add(7); pq.add(6);

        for(int ele : pq){
            System.out.print(ele + " ");
        }
    }
}
