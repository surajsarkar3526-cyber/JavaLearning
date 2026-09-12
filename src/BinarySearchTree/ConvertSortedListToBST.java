package BinarySearchTree;

public class ConvertSortedListToBST {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        TreeNode root = sortedListToBST(head);
        System.out.print("Inorder Traversal: ");
        inorder(root);
    }
    static ListNode head;
    private static TreeNode sortedListToBST(ListNode listHead) {
        head = listHead;
        int size = 0;
        ListNode current = listHead;
        while(current != null){
            size++;
            current = current.next;
        }
        return buildTrees(0,size-1);
    }

    private static TreeNode buildTrees(int left, int right) {
        if(left > right){
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode leftSubTree = buildTrees(left, mid - 1);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        root.left = leftSubTree;
        root.right = buildTrees(mid+1,right);
        return root;
    }

    private static void inorder(TreeNode root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.val+" ");
        inorder(root.right);
    }
}
