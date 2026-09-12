package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;

public class FindMedianInStream {

    public static void main(String[] args) {

        int[] arr = {5, 15, 1, 3, 2, 8};

        ArrayList<Double> result = getMedian(arr);

        System.out.println("Input Stream:");

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println("\n");

        System.out.println("Median after each insertion:");
        System.out.println(result);
    }

    public static ArrayList<Double> getMedian(int[] arr) {

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        ArrayList<Double> ans = new ArrayList<>();
        for (int num : arr) {

            if (left.isEmpty() || num <= Objects.requireNonNull(left.peek())) {
                left.offer(num);
            }
            else {
                right.offer(num);
            }
            if (left.size() > right.size() + 1) {
                right.offer(Objects.requireNonNull(left.poll()));
            }
            else if (right.size() > left.size() + 1) {
                left.offer(Objects.requireNonNull(right.poll()));
            }
            if (left.size() == right.size()) {

                double median =
                        (Objects.requireNonNull(left.peek())
                                + Objects.requireNonNull(right.peek())) / 2.0;
                ans.add(median);
            }
            else if (left.size() > right.size()) {

                ans.add((double) Objects.requireNonNull(left.peek()));
            }
            else {

                ans.add((double) Objects.requireNonNull(right.peek()));
            }
        }
        return ans;
    }
}
