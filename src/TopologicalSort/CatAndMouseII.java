package TopologicalSort;

import java.util.ArrayList;
import java.util.List;

public class CatAndMouseII {
    private static final int MOUSE_WIN = 1;
    private static final int CAT_WIN = 2;
    public static void main(String[] args) {
        CatAndMouseII solution = new CatAndMouseII();
        String[] grid1 = {"####F", "#C...", "M...."};
        System.out.println(solution.canMouseWin(grid1, 1, 2));
        String[] grid2 = {"M.C...F"};
        System.out.println(solution.canMouseWin(grid2, 1, 4));
        String[] grid3 = {"M.C...F"};
        System.out.println(solution.canMouseWin(grid3, 1, 3));
    }

    private boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int rows = grid.length;
        int cols = grid[0].length();
        int mouse = -1;
        int cat = -1;
        int food = -1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char ch = grid[r].charAt(c);
                int pos = r * cols + c;
                if (ch == 'M') {
                    mouse = pos;
                }
                else if (ch == 'C') {
                    cat = pos;
                }
                else if (ch == 'F') {
                    food = pos;
                }
            }
        }
        int total = rows * cols;
        @SuppressWarnings("unchecked")
        List<Integer>[] moves = new ArrayList[total];
        for (int j = 0; j < total; j++) {
            moves[j] = new ArrayList<>();
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r].charAt(c) == '#') {
                    continue;
                }
                int pos = r * cols + c;
                moves[pos].add(pos);
                for (int d = 0; d < 4; d++) {
                    for (int step = 1; step <= Math.max(catJump, mouseJump); step++) {
                        int nr = r + dr[d] * step;
                        int nc = c + dc[d] * step;
                        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                            break;
                        }
                        if (grid[nr].charAt(nc) == '#') {
                            break;
                        }
                        moves[pos].add(nr * cols + nc);
                    }
                }
            }
        }
        int[][][][] dp = new int[total][total][2][1001];
        for (int m = 0; m < total; m++) {
            if (grid[m / cols].charAt(m % cols) == '#') {
                continue;
            }
            for (int c = 0; c < total; c++) {
                if (grid[c / cols].charAt(c % cols) == '#') {
                    continue;
                }
                for (int turn = 0; turn < 2; turn++) {
                    dp[m][c][turn][0] = CAT_WIN;
                    if (m == c || c == food) {
                        dp[m][c][turn][0] = CAT_WIN;
                    }
                    else if (m == food) {
                        dp[m][c][turn][0] = MOUSE_WIN;
                    }
                }
            }
        }
        for (int t = 1; t <= 1000; t++) {
            for (int m = 0; m < total; m++) {
                if (grid[m / cols].charAt(m % cols) == '#') {
                    continue;
                }
                for (int c = 0; c < total; c++) {
                    if (grid[c / cols].charAt(c % cols) == '#') {
                        continue;
                    }
                    for (int turn = 0; turn < 2; turn++) {
                        if (m == c || c == food) {
                            dp[m][c][turn][t] = CAT_WIN;
                            continue;
                        }
                        if (m == food) {
                            dp[m][c][turn][t] = MOUSE_WIN;
                            continue;
                        }
                        boolean canWin = false;
                        if (turn == 0) {
                            for (int nextMouse : moves[m]) {
                                int distance = Math.abs(nextMouse / cols - m / cols) + Math.abs(nextMouse % cols - m % cols);
                                if (distance > mouseJump) {
                                    continue;
                                }
                                if (dp[nextMouse][c][1][t - 1] == MOUSE_WIN) {
                                    canWin = true;
                                    break;
                                }
                            }
                            dp[m][c][turn][t] = canWin ? MOUSE_WIN : CAT_WIN;

                        }
                        else {
                            for (int nextCat : moves[c]) {
                                int distance = Math.abs(nextCat / cols - c / cols) + Math.abs(nextCat % cols - c % cols);
                                if (distance > catJump) {
                                    continue;
                                }
                                if (dp[m][nextCat][0][t - 1] == CAT_WIN) {
                                    canWin = true;
                                    break;
                                }
                            }
                            dp[m][c][turn][t] = canWin ? CAT_WIN : MOUSE_WIN;
                        }
                    }
                }
            }
        }
        return dp[mouse][cat][0][1000] == MOUSE_WIN;
    }
}

