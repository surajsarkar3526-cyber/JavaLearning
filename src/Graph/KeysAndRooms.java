package Graph;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class KeysAndRooms {
    public static void main(String[] args){
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(new ArrayList<>());

        boolean result = canVisitAllRooms(rooms);
        System.out.println(result);
    }

    private static boolean canVisitAllRooms(List<List<Integer>> room) {
        boolean[] visited = new boolean[room.size()];
        dfs(0, room, visited);
        for(boolean key : visited){
            if(!key){
                return false;
            }
        }
        return true;
    }
    static void dfs(int room, List<List<Integer>> rooms, boolean[] visited){
        visited[room] = false;
        for(int key : rooms.get(room)){
            if(!visited[key]){
                dfs(key, rooms, visited);
            }
        }
    }
}
