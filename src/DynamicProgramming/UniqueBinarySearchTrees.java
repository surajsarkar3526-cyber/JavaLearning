package DynamicProgramming;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        int n = 3;
        int answer = numTrees(n);
        System.out.println("Number of unique BSTs = " + answer);
    }

    private static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int node = 2; node <= n; node++){
            for(int root = 1; root <= node; root++){
                int leftNode = root - 1;
                int rightNode = node - root;
                dp[node] += dp[leftNode] * dp[rightNode];
            }
        }
        return dp[n];
    }
}
