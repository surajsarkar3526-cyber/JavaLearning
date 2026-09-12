package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CircularGame {

    public static int findTheWinner(int n, int k) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }

            queue.poll();
        }
        Integer winner = queue.peek();

        if (winner == null) {
            throw new IllegalStateException("Queue is empty");
        }

        return winner;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players (n): ");
        int n = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int winner = findTheWinner(n, k);

        System.out.println("Winner is: " + winner);

        sc.close();
    }
}
