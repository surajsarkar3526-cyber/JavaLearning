package ArrayList_2DArray;

import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals obj = new MergeIntervals();
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        int[][] answer = obj.merge(intervals);
        for (int[] interval : answer) {
            System.out.println(
                    "[" + interval[0] + ", " + interval[1] + "]"
            );
        }
    }

    private int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        int[][] result = new int[intervals.length][intervals[0].length];
        int index = 0;
        result[index] = intervals[0];
        for(int i=1; i< intervals.length; i++){
            int[] previous = result[index];
            int[] current = intervals[i];
            if(current[0] <= previous[1]){
                previous[1] = Math.max(previous[1], current[1]);
            }
            else{
                index++;
                result[index] = current;
            }
        }
        return Arrays.copyOf(result, index+1);
    }
}
