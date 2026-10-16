package Graph;

public class RedundantConnection {
    public static void main(String[] args) {
        RedundantConnection obj = new RedundantConnection();
        int[][] edges = {
                {1, 2},
                {1, 3},
                {2, 3}
        };
        int[] result = obj.findRedundantConnection(edges);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

    private int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parents = new int[n+1];
        for(int i=1; i<=n; i++){
            parents[i] = i;
        }
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            int parentA = find(parents, a);
            int parentB = find(parents, b);
            if(parentA == parentB){
                return edge;
            }
            parents[parentA] = parentB;
        }
        return new int[0];
    }
    private int find(int[] parent, int x) {
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
