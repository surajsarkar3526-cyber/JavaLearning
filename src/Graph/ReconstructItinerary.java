package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Arrays;

public class ReconstructItinerary {
    static Map<String, PriorityQueue<String>> graph = new HashMap<>();
    static LinkedList<String> itinerary = new LinkedList<>();
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));
        List<String> result = findItinerary(tickets);
        System.out.println(result);
    }

    private static List<String> findItinerary(List<List<String>> tickets) {
        graph.clear();
        itinerary.clear();
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }
        DFSs("JFK");
        return itinerary;
    }

    private static void DFSs(String airport) {
        while(graph.containsKey(airport) &&
                !graph.get(airport).isEmpty()){
            String nextAirport = graph.get(airport).poll();
            DFSs(nextAirport);
        }
        itinerary.addFirst(airport);
    }
}
