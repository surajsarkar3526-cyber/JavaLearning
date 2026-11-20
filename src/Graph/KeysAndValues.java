package Graph;

import java.util.*;

public class KeysAndValues {
    static Queue<Integer> pq = new LinkedList<>();
    public static void main(String[] args){
        List<List<Integer>> room = new ArrayList<>();
        room.add(Arrays.asList(1));
        room.add(Arrays.asList(2));
        room.add(Arrays.asList(3));
        room.add(new ArrayList<>());

        boolean result = canVisitAllRooms(room);
        System.out.println(result);
    }
    private static boolean canVisitAllRooms(List<List<Integer>> room){
        int n = room.size();
        boolean[] visited = new boolean[n];
        bfs(room, visited, 0);
        for(boolean key : visited){
            if(!key){
                return false;
            }
        }
        return true;
    }
    private static void bfs(List<List<Integer>> room, boolean[] visited, int start){
        pq.add(start);
        visited[start] = true;
        while(!pq.isEmpty()){
            int node = pq.poll();
            for(int i=0; i<room.get(node).size(); i++){
                int key = room.get(node).get(i);
                if(!visited[key]){
                    pq.add(key);
                    visited[key] = true;
                }
            }
        }
    }
}
