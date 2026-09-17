package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBSTs {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);
        List<Integer> result = getAllElements(root1, root2);
        System.out.println(result);
    }
    public static void inorder(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    private static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);

        List<Integer> answer = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()){
            if(list1.get(i) < list2.get(j)){
                answer.add(list1.get(i));
                i++;
            }
            else{
                answer.add(list2.get(j));
                j++;
            }
        }
        while(i < list1.size()){
            answer.add(list1.get(i));
            i++;
        }
        while(j < list2.size()){
            answer.add(list2.get(j));
            j++;
        }
        return answer;
    }
}
