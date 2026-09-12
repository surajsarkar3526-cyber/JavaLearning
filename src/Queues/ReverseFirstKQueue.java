package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ReverseFirstKQueue {
    public static void main(String[] main){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue Size : ");
        int n = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        System.out.print("Enter Queue Elements : ");
        for(int i=0; i<n; i++){
            queue.add(sc.nextInt());

        }

        System.out.print("Enter K : ");
        int k = sc.nextInt();

        System.out.println("Original Queue: " + queue);
        reverseKElements(queue, k);

        System.out.println("Queue after reversing first " + k + " elements:");
        System.out.println(queue);

        sc.close();

    }

    private static void reverseKElements(Queue<Integer> queue, int k) {

        if(queue.isEmpty() || k <= 0 || k > queue.size()){
            System.out.println("Invalid Queue!");
            return;

        }

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<k; i++){
            stack.push(queue.remove());

        }

        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }

        int remaining = queue.size() - k;

        for(int i=0; i<remaining; i++){
            queue.add(queue.remove());

        }
    }
}
