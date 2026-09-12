package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ReverseQueue {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        System.out.print("Enter Size of Queue : ");
        int n = sc.nextInt();

        System.out.print("Enter Queue Elements : ");
        for(int i=0; i<n; i++){
            queue.add(sc.nextInt());

        }

        System.out.print("Original Queue "+" : "+queue);
        reverseQueue(queue);
    }

    private static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while(!queue.isEmpty()){
            stack.push(queue.remove());

        }

        while(!stack.isEmpty()){
            queue.add(stack.pop());

        }
        int k = queue.size();

        for(int i=0; i<k; i++){
            System.out.print(queue.remove()+" ");
        }
    }
}
