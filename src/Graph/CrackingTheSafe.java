package Graph;

import java.util.HashSet;
import java.util.Set;

public class CrackingTheSafe {
    public static void main(String[] args) {
        int n = 2;
        int k = 2;
        CrackingTheSafe solution = new CrackingTheSafe();
        String result = solution.crackSafe(n, k);
        System.out.println("Safe Password Sequence: " + result);
        System.out.println("Length: " + result.length());
    }

    private String crackSafe(int n, int k) {
        int total = (int)Math.pow(k,n);
        StringBuilder result = new StringBuilder();
        Set<String> visited = new HashSet<>();
        String start = "0".repeat(n-1);
        dfs(start, k, total, visited, result, n);
        result.append(start);
        return result.toString();
    }
    private void dfs(String node, int k, int total, Set<String> visited, StringBuilder result, int n) {
        for(int digit=0; digit<k; digit++) {
            String password = node + digit;
            if (!visited.contains(password)) {
                visited.add(password);
                dfs(password.substring(1), k, total, visited, result, n);
                result.append(digit);
            }
        }
    }
}
