package Arrays;

public class MaximumIndex {
    public static void main(String[] args){
        int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(maxIndexDiff(arr));
    }

    private static int maxIndexDiff(int[] arr) {
        int maxDiff = 0;
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=n-1; j>=i; j--){
                if(arr[i] <= arr[j]){
                    maxDiff = Math.max(maxDiff, j-i);
                    break;
                }
            }
        }
        return maxDiff;
    }
}
