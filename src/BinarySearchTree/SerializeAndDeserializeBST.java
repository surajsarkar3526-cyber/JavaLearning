package BinarySearchTree;
class codec{

    public static TreeNode Deserialized(String data) {
        if(data == null || data.isEmpty()){
            return null;
        }
        String[] values = data.split(",");
        int[] index = {0};
        return BuildTree(values, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static TreeNode BuildTree(String[] values, int[] index, int lower, int upper) {
        if(index[0] >= values.length){
            return null;
        }
        int value = Integer.parseInt(values[index[0]]);
        TreeNode root = new TreeNode(value);
        if(value > upper || value < lower){
            return null;
        }
        index[0]++;
        root.left = BuildTree(values, index, lower, value);
        root.right = BuildTree(values, index, value, upper);

        return root;
    }
    public String serialized(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder result = new StringBuilder();
        Preorder(root, result);
        return result.toString();
    }
    private void Preorder(TreeNode root, StringBuilder result) {
        if(root == null){
            return;
        }
        result.append(root.val).append(",");
        Preorder(root.left, result);
        Preorder(root.right, result);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
public class SerializeAndDeserializeBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        codec code = new codec();
        String data = code.serialized(root);
        System.out.println("Serialized String: " + data);

        TreeNode newRoot = codec.Deserialized(data);
        System.out.println("DeSerialized Root : " + newRoot);
        printPreorder(newRoot);
    }
    private static void printPreorder(TreeNode newRoot) {
        if(newRoot == null){
            return;
        }
        System.out.println(newRoot.val);
        printPreorder(newRoot.left);
        printPreorder(newRoot.right);
    }
}
