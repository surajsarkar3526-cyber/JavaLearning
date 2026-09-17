package Recursion;
import java.util.Arrays;
public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        generatePermutations(arr, 0);
    }

    private static void generatePermutations(int[] arr, int index) {
        if(index == arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i = index; i<arr.length; i++){
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;

            generatePermutations(arr, index+1);
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
}
