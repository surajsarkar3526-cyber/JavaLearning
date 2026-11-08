package Arrays;

import java.util.Arrays;

public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3},
                {2, 2}
        };
        int[] result = findMissingAndRepeatedValues(grid);
        System.out.println("Repeated Number: " + result[0]);
        System.out.println("Missing Number: " + result[1]);
        System.out.println("Final Result: "+Arrays.toString(result));
    }

    private static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[n*n + 1];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                freq[grid[i][j]]++;
            }
        }
        int Repeated = -1;
        int missing = -1;
        int m = freq.length;
        for(int k = 1; k<m; k++){
            if(freq[k] == 2){
                Repeated = k;
            }
            else if(freq[k] == 0){
                missing = k;
            }
        }
        return new int[]{Repeated,missing};
    }
}
