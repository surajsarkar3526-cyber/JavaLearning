package Graph;

import java.util.PriorityQueue;

public class SwimInRisingWater {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 2},
                {1, 3}
        };
        System.out.println(swimInWater(grid));
    }
    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
        );
        pq.offer(new int[]{grid[0][0], 0, 0});
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentTime = current[0];
            int row = current[1];
            int col = current[2];
            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;
            if (row == n - 1 && col == n - 1) {
                return currentTime;
            }
            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }
                if (!visited[nr][nc]) {
                    int nextTime = Math.max(currentTime,grid[nr][nc]);
                    pq.offer(new int[]{nextTime, nr, nc});
                }
            }
        }
        return -1;
    }
}
