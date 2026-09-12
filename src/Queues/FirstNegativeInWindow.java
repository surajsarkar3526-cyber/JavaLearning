package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FirstNegativeInWindow {

    public static void firstNegative(int[] arr, int k) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                queue.offer(i);
            }
        }

        if (queue.isEmpty()) {
            System.out.print("0 ");
        }
        else {
            System.out.print(arr[queue.peek()] + " ");
        }

        for (int i = k; i < arr.length; i++) {

            while (!queue.isEmpty() && queue.peek() <= i - k) {
                queue.poll();
            }

            if (arr[i] < 0) {
                queue.offer(i);
            }

            if (queue.isEmpty()) {
                System.out.print("0 ");
            }
            else {
                System.out.print(arr[queue.peek()] + " ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter window size: ");
        int k = sc.nextInt();

        if (k > n || k <= 0) {
            System.out.println("Invalid window size!");
            return;
        }

        firstNegative(arr, k);

        sc.close();
    }
}
