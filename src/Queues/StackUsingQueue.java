package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackUsingQueue {

    private final Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.offer(x);

        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        if (queue.isEmpty()) {
            System.out.println("Stack is Empty!");
            return -1;
        }
        return queue.poll();
    }

    public int top() {
        if (queue.isEmpty()) {
            System.out.println("Stack is Empty!");
            return -1;
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StackUsingQueue stack = new StackUsingQueue();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        System.out.println("\nTop Element = " + stack.top());

        System.out.println("Popped Element = " + stack.pop());

        System.out.println("Top After Pop = " + stack.top());

        System.out.println("\nRemaining Stack Elements:");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        sc.close();
    }
}
