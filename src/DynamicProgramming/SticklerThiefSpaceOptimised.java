package DynamicProgramming;

public class SticklerThiefSpaceOptimised {
    public static void main(String[] args) {

        int[] arr = {5, 5, 10, 100, 10, 5};

        System.out.println(maxLoot(arr));
    }

    private static int maxLoot(int[] arr) {
        int n = arr.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return arr[0];
        }

        int prev2 = 0;
        int prev1 = arr[0];

        for(int i = 1; i<n; i++){
            int current = Math.max(arr[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
