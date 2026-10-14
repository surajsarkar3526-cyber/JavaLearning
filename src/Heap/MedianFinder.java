package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public MedianFinder(){
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
    private double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        }
        return (small.peek() + large.peek()) / 2.0;
    }

    private void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());
        if(small.size() < large.size()){
            small.offer(large.poll());
        }
    }
}
