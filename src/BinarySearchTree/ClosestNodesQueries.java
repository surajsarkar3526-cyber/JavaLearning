package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class ClosestNodesQueries {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(15);
        root.right.right.left = new TreeNode(14);
        List<Integer> queries = new ArrayList<>();
        queries.add(2);
        queries.add(5);
        queries.add(16);
        List<List<Integer>> answer = closestNodes(root, queries);
        System.out.println(answer);
    }

    private static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> answer = new ArrayList<>();
        for(int query : queries){
            int mini = -1;
            int maxi = -1;
            TreeNode current = root;
            while(current != null){
                if(current.val == query){
                    mini = current.val;
                    maxi = current.val;
                }
                else if(current.val < query){
                    mini = current.val;
                    current = current.right;
                }
                else{
                    maxi = current.val;
                    current = current.left;
                }
            }
            List<Integer> result = new ArrayList<>();
            result.add(mini);
            result.add(maxi);

            answer.add(result);
        }
        return answer;
    }
}
