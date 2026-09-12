package Graph;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleI {
    public static boolean canFinish(int n, int[][] pre) {
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[n];
        for (int[] pair : pre) {
            int course = pair[0];
            int prerequisite = pair[1];
            graph[prerequisite].add(course);
            indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            for (int next : graph[current]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return count == n;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] pre = {
                {2, 0},
                {2, 1},
                {3, 2}
        };
        System.out.println(canFinish(n, pre));
    }
}
