package Graph;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int result = findCircleNum(isConnected);
        System.out.println("Number Of Provinces : " + result);
    }

    private static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for(int i=0; i<n; i++){
            if (!visited[i]){
                DFS(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }

    private static void DFS(int[][] isConnected, boolean[] visited, int i) {
        visited[i] = true;
        for(int j=0; j<isConnected.length; j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                DFS(isConnected, visited, j);
            }
        }
    }
}
