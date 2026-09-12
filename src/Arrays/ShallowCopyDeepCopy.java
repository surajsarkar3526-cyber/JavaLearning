package Arrays;
import java.util.Arrays;
public class ShallowCopyDeepCopy {
    public static void main(String[] args){
        int[] arr = {10,20,30,40};

//        int[] x = arr; //  --> Shallow copy
//        x[3] = 50;
//        System.out.print(arr[3]);

        int[] deep = Arrays.copyOf(arr,arr.length);
        deep[3] = 50;
        System.out.println(arr[3]);
        System.out.println(deep[3]);
    }
}
