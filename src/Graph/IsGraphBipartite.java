package Graph;

public class IsGraphBipartite {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1,2,3},
                {0,2},
                {0,1,3},
                {0,2}
        };
        System.out.println(isBipertite(graph));
    }

    private static boolean isBipertite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for(int i=0; i<n; i++){
            if(color[i] == -1){
                if(!dfs(i, 0, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean dfs(int node, int col, int[][] graph, int[] color){
        color[node] = col;
        for(int ele : graph[node]){
            if(color[ele] == -1){
                if(!dfs(ele, 1-col, graph, color)){
                    return false;
                }
                else if(color[ele] == col){
                    return false;
                }
            }
        }
        return true;
    }
}
