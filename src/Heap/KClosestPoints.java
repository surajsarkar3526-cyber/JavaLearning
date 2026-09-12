package Heap;

import java.util.PriorityQueue;

class Triplet implements Comparable<Triplet>{
    int dist;
    int x;
    int y;
    Triplet(int dist, int x, int y){
        this.dist = dist;
        this.x = x;
        this.y = y;
    }

    public int compareTo(Triplet t){
        return t.dist - this.dist;
    }
}
public class KClosestPoints {

    public static void main(String[] args) {

        int[][] points = {
                {1, 3},
                {-2, 2},
                {5, 8},
                {0, 1}
        };

        int k = 2;

        int[][] result = kClosest(points, k);

        System.out.println("K Closest Points to Origin:");

        for (int[] point : result) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }

    private static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        for(int[] point : points){
            int x = point[0], y = point[1];
            int dist = x*x + y*y;
            pq.add(new Triplet(dist,x,y));
            if(pq.size()>k){
                pq.remove();
            }
        }
        int[][] ans = new int[k][2];
        for(int i=0; i<k; i++){
            Triplet top = pq.remove();
            ans[i][0] = top.x;
            ans[i][1] = top.y;

        }

        return ans;
    }
}
