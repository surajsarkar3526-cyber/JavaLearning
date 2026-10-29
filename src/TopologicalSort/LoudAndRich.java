package TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoudAndRich {
    public static void main(String[] args) {
        LoudAndRich solution = new LoudAndRich();
        int[][] richer = {
                {1, 0},
                {2, 1},
                {3, 1},
                {3, 7},
                {4, 3},
                {5, 3},
                {6, 3}
        };
        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
        int[] answer = solution.loudAndRich(richer, quiet);
        System.out.println(Arrays.toString(answer));
    }

    private int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pair : richer){
            int richerPerson = pair[0];
            int poorerPerson = pair[1];
            graph.get(poorerPerson).add(richerPerson);
        }
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        for(int i=0; i<n; i++){
            dfs(i, graph, quiet, answer);
        }
        return answer;
    }
    private int dfs(int person, List<List<Integer>> graph, int[] quiet, int[] answer) {
        if(answer[person] != -1){
            return answer[person];
        }
        answer[person] = person;
        for(int richerP : graph.get(person)){
            int quietestPerson = dfs(richerP, graph, quiet, answer);
            if(quiet[quietestPerson] < quiet[answer[person]]){
                answer[person] = quietestPerson;
            }
        }
        return answer[person];
    }
}
