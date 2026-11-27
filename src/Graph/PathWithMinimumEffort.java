package Graph;

import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static class Triplet implements Comparable<Triplet>{
        int row;
        int col;
        int efforts;
        Triplet(int row, int col, int efforts){
            this.row = row;
            this.col = col;
            this.efforts = efforts;
        }
        @Override
        public int compareTo(Triplet t){
            return Integer.compare(this.efforts, t.efforts);
        }
    }
    public static void main(String[] args) {
        int[][] heights = new int[][]{
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
       System.out.println(minimumEffortPath(heights));
    }

    private static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        arr[0][0] = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.offer(new Triplet(0,0,0));
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};
        while(!pq.isEmpty()){
            Triplet current = pq.poll();
            int row = current.row;
            int col = current.col;
            int efforts = current.efforts;
            if(efforts > arr[row][col]){
                continue;
            }
            if(row == n-1 && col == m-1){
                return efforts;
            }
            for(int i=0; i<4; i++){
                int newRow = row + dr[i];
                int newCol = col + dc[i];
                if(newRow < 0 || newRow >= n || newCol < 0 || newCol >= m){
                    continue;
                }
                int ele = Math.abs(heights[row][col] - heights[newRow][newCol]);
                ele = Math.max(ele,efforts);
                if(ele < arr[newRow][newCol]){
                    arr[newRow][newCol] = ele;
                    pq.offer(new Triplet(newRow,newCol,ele));
                }
            }
        }
        return 0;
    }
}
