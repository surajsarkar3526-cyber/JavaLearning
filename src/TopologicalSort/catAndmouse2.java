package TopologicalSort;

import java.util.ArrayList;
import java.util.List;

public class catAndmouse2 {
    private static final int LIMIT = 1000;

    private int food;
    private int[][] mouseMoves;
    private int[][] catMoves;
    private byte[][][][] memo;

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int rows = grid.length;
        int cols = grid[0].length();
        int total = rows * cols;

        int mouse = -1;
        int cat = -1;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char ch = grid[r].charAt(c);
                int pos = r * cols + c;

                if (ch == 'M') mouse = pos;
                else if (ch == 'C') cat = pos;
                else if (ch == 'F') food = pos;
            }
        }

        mouseMoves = buildMoves(grid, mouseJump);
        catMoves = buildMoves(grid, catJump);

        memo = new byte[total][total][2][LIMIT + 1];

        return dfs(mouse, cat, 0, 0, mouseJump);
    }

    private int[][] buildMoves(String[] grid, int jump) {
        int rows = grid.length;
        int cols = grid[0].length();
        int total = rows * cols;

        int[][] moves = new int[total][];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int pos = r * cols + c;

                if (grid[r].charAt(c) == '#') {
                    moves[pos] = new int[0];
                    continue;
                }

                List<Integer> list = new ArrayList<>();
                list.add(pos);

                for (int d = 0; d < 4; d++) {
                    for (int step = 1; step <= jump; step++) {
                        int nr = r + dr[d] * step;
                        int nc = c + dc[d] * step;

                        if (nr < 0 || nr >= rows ||
                                nc < 0 || nc >= cols ||
                                grid[nr].charAt(nc) == '#') {
                            break;
                        }

                        list.add(nr * cols + nc);
                    }
                }

                moves[pos] = list.stream().mapToInt(Integer::intValue).toArray();
            }
        }

        return moves;
    }

    private boolean dfs(int mouse, int cat, int turn, int steps, int mouseJump) {
        if (mouse == cat || cat == food) {
            return false;
        }

        if (mouse == food) {
            return true;
        }

        if (steps >= LIMIT) {
            return false;
        }

        if (memo[mouse][cat][turn][steps] != 0) {
            return memo[mouse][cat][turn][steps] == 1;
        }

        if (turn == 0) {
            for (int nextMouse : mouseMoves[mouse]) {
                if (dfs(nextMouse, cat, 1, steps + 1, mouseJump)) {
                    memo[mouse][cat][turn][steps] = 1;
                    return true;
                }
            }

            memo[mouse][cat][turn][steps] = -1;
            return false;
        } else {
            for (int nextCat : catMoves[cat]) {
                if (!dfs(mouse, nextCat, 0, steps + 1, mouseJump)) {
                    memo[mouse][cat][turn][steps] = -1;
                    return false;
                }
            }

            memo[mouse][cat][turn][steps] = 1;
            return true;
        }
    }
}