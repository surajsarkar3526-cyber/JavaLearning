package BackTracking;

import java.util.ArrayList;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        ArrayList<String> result = findPaths(maze);

        System.out.println(result);
    }

    private static ArrayList<String> findPaths(int[][] maze) {

        ArrayList<String> result = new ArrayList<>();
        int n = maze.length;

        if(maze[0][0] == 0 || maze[n-1][n-1] == 0){
            return result;
        }

        boolean[][] visited = new boolean[n][n];
        solve(maze,0,0,visited,"",result);

        return result;
    }

    private static void solve(int[][] maze, int row, int col, boolean[][] visited, String path, ArrayList<String> result) {

        int n = maze.length;

        if(row == n-1 && col == n-1){
            result.add(path);
            return;
        }

        visited[row][col] = true;
        if(isSafe(maze, row+1, col, visited)){
            solve(maze, row+1, col, visited, path + "D", result);
        }

        if(isSafe(maze, row, col-1, visited)){
            solve(maze, row, col-1, visited, path + "L", result);
        }

        if(isSafe(maze, row, col + 1, visited)){
            solve(maze, row, col + 1, visited, path + "R", result);
        }

        if(isSafe(maze,row - 1, col, visited)){
            solve(maze, row - 1, col, visited, path + "U", result);
        }

        visited[row][col] = false;
    }

    private static boolean isSafe(int[][] maze, int row, int col, boolean[][] visited) {

        int n = maze.length;

        return row >= 0 && row < n
                && col >= 0 && col < n
                && maze[row][col] == 1
                && !visited[row][col];
    }
}
