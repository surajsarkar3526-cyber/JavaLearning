package Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {

    int ele;
    int freq;

    Pair(int ele, int freq) {
        this.ele = ele;
        this.freq = freq;
    }

    @Override
    public int compareTo(Pair p) {

        if (this.freq == p.freq) {
            return this.ele - p.ele;
        }

        return this.freq - p.freq;
    }
}

public class TopKFrequentElements {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] ans = topKFrequent(nums, k);

        System.out.print("Top K Frequent Elements : ");

        for (int x : ans) {
            System.out.print(x + " ");
        }
    }

    public static int[] topKFrequent(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int ele : map.keySet()) {

            int freq = map.get(ele);

            pq.offer(new Pair(ele, freq));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            list.add(top.ele);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
