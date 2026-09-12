package Queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class InterleaveQueue {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Even Size of Queue : ");
        int n = sc.nextInt();

        Queue<Integer> queue = new ArrayDeque<>();
        if(n % 2 != 0){
            System.out.println("Size of Queue Must be Even ");
            return;
        }

        System.out.print("Enter Queue Elements : ");
        for(int i=0; i<n; i++){
            queue.offer(sc.nextInt());
        }

        System.out.print("Original Queue " + queue);

        interleaveQueue(queue);
        System.out.println("Interleaved Queue: " + queue);

        sc.close();
    }

    private static void interleaveQueue(Queue<Integer> queue) {
        if (queue.size() % 2 != 0) {
            System.out.println("Queue size must be even.");
            return;
        }
        int half = queue.size()/2;

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<half; i++){
            stack.push(queue.poll());

        }
        for(int i=0; i<half; i++){
            queue.offer(stack.pop());
        }

        for(int i=0; i<half; i++){
            queue.offer(queue.poll());
        }

        for(int i=0; i<half; i++){
            stack.push(queue.poll());
        }
        while(!stack.isEmpty()){
            queue.offer(stack.pop());
            queue.offer(queue.poll());

        }
    }
}
