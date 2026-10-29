package TopologicalSort;

import java.util.ArrayDeque;
import java.util.Queue;

public class CatAndMouse {

    private static final int DRAW = 0;
    private static final int MOUSE_WIN = 1;
    private static final int CAT_WIN = 2;
    private static final int MOUSE_TURN = 0;
    private static final int CAT_TURN = 1;

    public static void main(String[] args) {
        CatAndMouse solution = new CatAndMouse();
        int[][] graph = {
                {2, 5},
                {3},
                {0, 4, 5},
                {1, 4, 5},
                {2, 3},
                {0, 2, 3}
        };
        int answer = solution.catMouseGame(graph);
        System.out.println(answer);
    }

    private int catMouseGame(int[][] graph) {
        int n = graph.length;
        int[][][] color = new int[n][n][2];
        int[][][] degree = new int[n][n][2];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int mouse = 0; mouse < n; mouse++) {
            for (int cat = 1; cat < n; cat++) {
                degree[mouse][cat][MOUSE_TURN] = graph[mouse].length;
                int catMoves = 0;
                for (int next : graph[cat]) {
                    if (next != 0) {
                        catMoves++;
                    }
                }
                degree[mouse][cat][CAT_TURN] = catMoves;
            }
        }
        for (int cat = 1; cat < n; cat++) {
            for (int turn = 0; turn < 2; turn++) {
                color[0][cat][turn] = MOUSE_WIN;
                queue.offer(new int[]{0, cat, turn, MOUSE_WIN});
            }
        }
        for (int node = 1; node < n; node++) {
            for (int turn = 0; turn < 2; turn++) {
                color[node][node][turn] = CAT_WIN;
                queue.add(new int[]{node, node, turn, CAT_WIN});
            }
        }
        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int mouse = state[0];
            int cat = state[1];
            int turn = state[2];
            int result = state[3];
            if (turn == MOUSE_TURN) {
                for (int previousCat : graph[cat]) {
                    if (previousCat == 0) {
                        continue;
                    }
                    if (color[mouse][previousCat][CAT_TURN] != DRAW) {
                        continue;
                    }
                    if (result == CAT_WIN) {
                        color[mouse][previousCat][CAT_TURN] = CAT_WIN;
                        queue.offer(new int[]{
                                mouse, previousCat, CAT_TURN, CAT_WIN
                        });
                    }
                    else {
                        degree[mouse][previousCat][CAT_TURN]--;
                        if (degree[mouse][previousCat][CAT_TURN] == 0) {
                            color[mouse][previousCat][CAT_TURN] = MOUSE_WIN;
                            queue.offer(new int[]{
                                    mouse, previousCat, CAT_TURN, MOUSE_WIN
                            });
                        }
                    }
                }
            }
            else {
                for (int previousMouse : graph[mouse]) {
                    if (color[previousMouse][cat][MOUSE_TURN] != DRAW) {
                        continue;
                    }
                    if (result == MOUSE_WIN) {
                        color[previousMouse][cat][MOUSE_TURN] = MOUSE_WIN;
                        queue.offer(new int[]{
                                previousMouse, cat, MOUSE_TURN, MOUSE_WIN
                        });
                    }
                    else {
                        degree[previousMouse][cat][MOUSE_TURN]--;
                        if (degree[previousMouse][cat][MOUSE_TURN] == 0) {
                            color[previousMouse][cat][MOUSE_TURN] = CAT_WIN;
                            queue.offer(new int[]{
                                    previousMouse, cat, MOUSE_TURN, CAT_WIN
                            });
                        }
                    }
                }
            }
        }
        return color[1][2][MOUSE_TURN];
    }
}