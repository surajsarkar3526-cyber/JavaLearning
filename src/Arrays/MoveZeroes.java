package Arrays;
import java.util.Arrays;
public class MoveZeroes {
    public static void main(String[] args){
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZeroes(int[] arr) {
        int index = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                arr[index] = arr[i];
                index++;
            }
        }
        while(index < arr.length){
            arr[index] = 0;
            index++;
        }
    }
}
