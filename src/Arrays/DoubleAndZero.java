package Arrays;
import java.util.Arrays;
public class DoubleAndZero {
    public static void main(String[] args){
        int[] arr = {2, 2, 0, 4, 0, 8};
        int[] result = modifyArray(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] modifyArray(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            if(arr[i] != 0 && arr[i] == arr[i+1]){
                arr[i] = arr[i]*2;
                arr[i+1] = 0;
            }
        }
        int index = 0;
        for(int i=0; i<n; i++){
            if(arr[i] != 0){
                arr[index++] = arr[i];
            }
        }
        while(index < n){
            arr[index++] = 0;
        }
        return arr;
    }
}
