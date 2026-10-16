package Graph;

public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int[] edge1 = null;
        int[] edge2 = null;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (parent[v] != v) {
                edge1 = new int[]{parent[v], v};
                edge2 = edge;
                edge[1] = 0;
            }
            else {
                parent[v] = u;
            }
        }
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (v == 0) {
                continue;
            }
            int rootU = find(parent, u);
            int rootV = find(parent, v);
            if (rootU == rootV) {
                if (edge2 == null) {
                    return edge;
                }
                return edge1;
            }
            parent[rootV] = rootU;
        }
        return edge2;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
