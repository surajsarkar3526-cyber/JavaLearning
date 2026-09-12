package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TraversalInQueues {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Queue<Integer> q = new LinkedList<>();
        q.add(10); q.add(20); q.add(30); q.add(40); q.add(50);
        display(q);
        AddAtIndex(q, 2,60);

        sc.close();
    }

    private static void AddAtIndex(Queue<Integer> q, int idx, int val) {

        int n = q.size();
        if(idx<0 || idx > n) {
            System.out.println("Invalid Index!");
            return;

        }

        if(idx < n){
            for(int i=1; i<=idx; i++){
                q.add(q.remove());
            }
        }
        q.add(val);
        for(int i=1; i<=n; i++){
            q.add(q.remove());
        }
    }

    private static void display(Queue<Integer> q) {
        int n = q.size();
        for(int i=0; i<n; i++){
            System.out.print(q.peek()+" ");
            q.remove();
        }
        System.out.println();
    }
}
