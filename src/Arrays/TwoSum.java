package Arrays;

public class TwoSum {
    public static void main(String[] args){
        int[] arr = {0, -1, 2, -3, 1};
        int target = -2;
        boolean answer = twoSum(arr, target);
        System.out.println(answer);
    }
    private static boolean twoSum(int[] arr, int target){
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] + arr[j] == target){
                    return true;
                }
            }
        }
        return false;
    }
}
