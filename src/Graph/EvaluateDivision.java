package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }
        double[] answer = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                answer[i] = -1.0;
            }
            else if (start.equals(end)) {
                answer[i] = 1.0;
            }
            else {
                Set<String> visited = new HashSet<>();
                answer[i] = dfs(start, end, 1.0, graph, visited);
            }
        }

        return answer;
    }
    private double dfs(String current,String target,double product,Map<String, Map<String, Double>> graph,Set<String> visited) {
        if (current.equals(target)) {
            return product;
        }
        visited.add(current);
        for (Map.Entry<String, Double> entry : graph.get(current).entrySet()) {
            String neighbor = entry.getKey();
            double value = entry.getValue();
            if (!visited.contains(neighbor)) {
                double result = dfs(neighbor, target, product * value, graph, visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        EvaluateDivision solution = new EvaluateDivision();
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );
        double[] result = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(result));
    }
}
