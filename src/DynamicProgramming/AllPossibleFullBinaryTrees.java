package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        AllPossibleFullBinaryTrees solution = new AllPossibleFullBinaryTrees();
        List<Node> trees = solution.allPossibleFBT(7);
        System.out.println("Total possible trees: " + trees.size());
    }

    private List<Node> allPossibleFBT(int n) {
        List<Node> result = new ArrayList<>();
        if(n%2==0){
            return result;
        }
        if(n==1){
            result.add(new Node(0));
            return result;
        }
        for(int leftNode = 1; leftNode<n; leftNode += 2){
            int rightNode = n - 1 - leftNode;
            List<Node> leftTree = allPossibleFBT(leftNode);
            List<Node> rightTree = allPossibleFBT(rightNode);
            for(Node left : leftTree){
                for(Node right : rightTree){
                    Node root = new Node(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
