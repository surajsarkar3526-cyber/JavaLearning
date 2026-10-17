package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContainVirus {
    private int m;
    private int n;
    private final int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public static void main(String[] args) {
        ContainVirus solution = new ContainVirus();
        int[][] isInfected = {
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        int result = solution.containVirus(isInfected);
        System.out.println("Total walls required: " + result);
    }

    public int containVirus(int[][] isInfected) {
        m = isInfected.length;
        n = isInfected[0].length;
        int totalWalls = 0;
        while (true) {
            List<List<int[]>> regions = new ArrayList<>();
            List<Set<String>> frontiers = new ArrayList<>();
            List<Integer> wallsNeeded = new ArrayList<>();
            boolean[][] visited = new boolean[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (isInfected[r][c] == 1
                            && !visited[r][c]) {
                        List<int[]> cells = new ArrayList<>();
                        Set<String> frontier = new HashSet<>();
                        int[] walls = {0};
                        dfs(r, c, isInfected, visited, cells, frontier, walls);
                        regions.add(cells);
                        frontiers.add(frontier);
                        wallsNeeded.add(walls[0]);
                    }
                }
            }
            if (regions.isEmpty()) {
                break;
            }
            int quarantineIndex = 0;
            for (int i = 1; i < frontiers.size(); i++) {
                if (frontiers.get(i).size() > frontiers.get(quarantineIndex).size()) {
                    quarantineIndex = i;
                }
            }
            if (frontiers.get(quarantineIndex).isEmpty()) {
                break;
            }
            totalWalls += wallsNeeded.get(quarantineIndex);
            for (int[] cell : regions.get(quarantineIndex)) {
                isInfected[cell[0]][cell[1]] = -1;
            }
            for (int i = 0; i < regions.size(); i++) {
                if (i == quarantineIndex) {
                    continue;
                }
                for (String cell : frontiers.get(i)) {
                    String[] parts = cell.split(",");
                    int r = Integer.parseInt(parts[0]);
                    int c = Integer.parseInt(parts[1]);
                    isInfected[r][c] = 1;
                }
            }
        }
        return totalWalls;
    }

    private void dfs(int r,int c,int[][] grid,boolean[][] visited,List<int[]> cells,Set<String> frontier,int[] walls) {
        visited[r][c] = true;
        cells.add(new int[]{r, c});
        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= m
                    || nc < 0 || nc >= n) {
                continue;
            }
            if (grid[nr][nc] == 0) {
                walls[0]++;
                frontier.add(nr + "," + nc);

            }
            else if (grid[nr][nc] == 1
                    && !visited[nr][nc]) {
                dfs(nr, nc, grid, visited, cells, frontier, walls);
            }
        }
    }
}
