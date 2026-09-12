package HashMap;

import java.util.HashMap;

public class Map_STL {
    public static void main(String[] args) {
       HashMap<String, Integer> map = new HashMap<>();
       map.put("Raghav", 25); map.put("Aditya",35);
       map.put("Vivek", 17); map.put("Deepika",20);
       for(String key : map.keySet()){
           System.out.println(key+" "+map.get(key));
       }
        System.out.println(map.containsKey("Vivek"));
        System.out.println(map+" "+map.size());
        System.out.println(map.remove("Vivek"));
        System.out.println(map.get("Raghav"));
        System.out.println(map.containsKey("Vivek"));
    }
}
