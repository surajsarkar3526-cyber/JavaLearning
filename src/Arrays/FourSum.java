package Arrays;
import java.util.Arrays;
public class FourSum {
    public static void main(String[] args){
        int[] arr = {1, 5, 1, 0, 6, 0};
        int x = 7;
        boolean result = fourSum(arr, x);
        System.out.println(result);
    }

    private static boolean fourSum(int[] arr, int x) {
        int n = arr.length;
        Arrays.sort(arr);
        for(int i=0; i<n-3; i++){
            for(int j=i+1; j<n-2; j++){
                int left = j+1;
                int right = n-1;
                while(left<right){
                    long sum = (long)arr[i]+
                            arr[j]+
                            arr[left]+
                            arr[right];
                    if(sum == x){
                        return true;
                    }
                    else if(sum < x){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return false;
    }
}
