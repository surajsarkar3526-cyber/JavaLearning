package Arrays;
import java.util.Arrays;
import java.util.ArrayList;

public class AlternatePositiveNegative {
    public static void main(String[] args){
        int[] arr = {9, 4, -2, -1, 5, 0, -5, -3, 2};
        rearrange(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void rearrange(int[] arr) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for(int num : arr){
            if(num >= 0){
                positive.add(num);
            }
            else{
                negative.add(num);
            }
        }
        int i=0;
        int j=0;
        int k=0;
        while(i<positive.size() && j<negative.size()){
            arr[k++] = positive.get(i++);
            arr[k++] = negative.get(j++);
        }
        while(i<positive.size()){
            arr[k++] = positive.get(i++);
        }
        while(j<negative.size()){
            arr[k++] = negative.get(j++);
        }
    }
}
