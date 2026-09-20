package BinaryTree;

public class SerializeDeserializeBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    static class Codec{
        public String serialize(TreeNode root){
            StringBuilder result = new StringBuilder();
            serializeHelper(result, root);
            return result.toString();
        }

        private void serializeHelper(StringBuilder result, TreeNode root) {
            if(root == null){
                result.append("#,");
                return;
            }
            result.append(root.val).append(",");
            serializeHelper(result, root.left);
            serializeHelper(result, root.right);
        }

        public TreeNode deserialize(String data) {
            String[] values = data.split(",");
            int[] index = {0};
            return deserializeHelper(values, index);
        }

        private TreeNode deserializeHelper(String[] values, int[] index) {
            if(values[index[0]].equals("#")){
                index[0]++;
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(values[index[0]]));
            index[0]++;
            root.left = deserializeHelper(values,index);
            root.right = deserializeHelper(values, index);

            return root;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Codec codec = new Codec();
        String data = codec.serialize(root);
        System.out.println("Serialized Tree:");
        System.out.println(data);
        TreeNode newRoot = codec.deserialize(data);
        System.out.println("\nDeserialized Tree:");
        printPreorder(newRoot);
    }

    private static void printPreorder(TreeNode node) {
        if(node == null){
            return;
        }
        System.out.print(node.val+" ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}
