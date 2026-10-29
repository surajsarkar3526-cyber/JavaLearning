package TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SortItemsByGroups {
    public static void main(String[] args) {
        SortItemsByGroups solution = new SortItemsByGroups();
        int n = 8;
        int m = 2;
        int[] group = {-1, -1, 1, 0, 0, 1, 0, -1};
        List<List<Integer>> beforeItems = new ArrayList<>();
        beforeItems.add(new ArrayList<>(List.of()));
        beforeItems.add(new ArrayList<>(List.of(6)));
        beforeItems.add(new ArrayList<>(List.of(5)));
        beforeItems.add(new ArrayList<>(List.of(6)));
        beforeItems.add(new ArrayList<>(List.of(3, 6)));
        beforeItems.add(new ArrayList<>(List.of()));
        beforeItems.add(new ArrayList<>(List.of()));
        beforeItems.add(new ArrayList<>(List.of()));
        int[] result = solution.sortItems(n, m, group, beforeItems);
        System.out.println(java.util.Arrays.toString(result));
    }

    private int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int totalGroups = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                totalGroups++;
            }
        }
        List<List<Integer>> itemGraph = new ArrayList<>();
        List<List<Integer>> groupGraph = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            itemGraph.add(new ArrayList<>());
        }
        for (int k = 0; k < totalGroups; k++) {
            groupGraph.add(new ArrayList<>());
        }
        int[] itemIndegree = new int[n];
        int[] groupIndegree = new int[totalGroups];
        for (int v = 0; v < n; v++) {
            for (int u : beforeItems.get(v)) {
                itemGraph.get(u).add(v);
                itemIndegree[v]++;
                if (group[u] != group[v]) {
                    groupGraph.get(group[u]).add(group[v]);
                    groupIndegree[group[v]]++;
                }
            }
        }
        List<Integer> itemOrder = topologicalSort(itemGraph, itemIndegree);
        List<Integer> groupOrder = topologicalSort(groupGraph, groupIndegree);
        if (itemOrder.size() != n
                || groupOrder.size() != totalGroups) {
            return new int[0];
        }
        List<List<Integer>> groupedItems = new ArrayList<>();
        for (int i = 0; i < totalGroups; i++) {
            groupedItems.add(new ArrayList<>());
        }
        for (int item : itemOrder) {
            groupedItems.get(group[item]).add(item);
        }
        int[] result = new int[n];
        int index = 0;
        for (int g : groupOrder) {
            for (int item : groupedItems.get(g)) {
                result[index++] = item;
            }
        }
        return result;
    }

    private List<Integer> topologicalSort(List<List<Integer>> graph, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);
            for (int v : graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return order;
    }
}
