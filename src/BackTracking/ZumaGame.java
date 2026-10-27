package BackTracking;

import java.util.*;

public class ZumaGame {
    public int findMinStep(String board, String hand) {
        char[] balls = hand.toCharArray();
        Arrays.sort(balls);
        hand = new String(balls);
        Queue<State> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new State(board, hand, 0));
        visited.add(board + "#" + hand);
        while (!queue.isEmpty()) {
            State current = queue.poll();
            if (current.board.isEmpty()) {
                return current.steps;
            }
            for (int h = 0; h < current.hand.length(); h++) {
                char ball = current.hand.charAt(h);
                if (h > 0 && current.hand.charAt(h - 1) == ball) {
                    continue;
                }
                String nextHand = current.hand.substring(0, h) + current.hand.substring(h + 1);
                for (int i = 0; i <= current.board.length(); i++) {
                    String nextBoard = current.board.substring(0, i) + ball + current.board.substring(i);
                    nextBoard = removeGroups(nextBoard);
                    if (nextBoard.isEmpty()) {
                        return current.steps + 1;
                    }
                    String key = nextBoard + "#" + nextHand;
                    if (visited.add(key)) {
                        queue.offer(new State(nextBoard, nextHand,current.steps + 1));
                    }
                }
            }
        }
        return -1;
    }

    private String removeGroups(String board) {
        while (true) {
            boolean removed = false;
            for (int i = 0; i < board.length();) {
                int j = i;
                while (j < board.length()
                        && board.charAt(j) == board.charAt(i)) {
                    j++;
                }
                if (j - i >= 3) {
                    board = board.substring(0, i) + board.substring(j);
                    removed = true;
                    break;
                }
                i = j;
            }
            if (!removed) {
                return board;
            }
        }
    }

    private static class State {

        String board;
        String hand;
        int steps;

        State(String board, String hand, int steps) {
            this.board = board;
            this.hand = hand;
            this.steps = steps;
        }
    }
    public static void main(String[] args) {
        ZumaGame game = new ZumaGame();
        System.out.println(game.findMinStep("WRRBBW", "RB"));
        System.out.println(game.findMinStep("WWRRBBWW", "WRBRW"));
        System.out.println(game.findMinStep("G", "GGGGG"));
    }
}
