package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BottomViewBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }

        public static void main(String[] args) {

            Node root = new Node(1);

            root.left = new Node(2);
            root.right = new Node(3);

            root.left.left = new Node(4);
            root.left.right = new Node(5);

            root.right.right = new Node(6);

            System.out.println(bottomView(root));
        }

        static ArrayList<Integer> bottomView(Node root) {

            ArrayList<Integer> ans = new ArrayList<>();

            if (root == null) {
                return ans;
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            Queue<Pair> queue = new LinkedList<>();

            queue.offer(new Pair(root, 0));

            int minHD = 0;
            int maxHD = 0;

            while (!queue.isEmpty()) {

                Pair current = queue.poll();

                Node node = current.node;
                int hd = current.hd;

                map.put(hd, node.data);

                minHD = Math.min(minHD, hd);
                maxHD = Math.max(maxHD, hd);

                if (node.left != null) {
                    queue.offer(new Pair(node.left, hd - 1));
                }

                if (node.right != null) {
                    queue.offer(new Pair(node.right, hd + 1));
                }
            }

            for (int hd = minHD; hd <= maxHD; hd++) {

                if (map.containsKey(hd)) {
                    ans.add(map.get(hd));
                }
            }

            return ans;
        }
    }
}
