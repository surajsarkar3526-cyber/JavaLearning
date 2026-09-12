package Queues;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue
    public void push(int x) {
        stack1.push(x);
    }

    // Dequeue
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {

        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();

        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Front: " + queue.peek());
        System.out.println("Removed: " + queue.pop());
        System.out.println("Front: " + queue.peek());

        queue.push(40);

        while (!queue.empty()) {
            System.out.println("Removed: " + queue.pop());
        }
    }
}
