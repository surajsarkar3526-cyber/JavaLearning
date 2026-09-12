package Arrays;
import java.util.Arrays;
public class IntersectionOfArrays {
    public static void main(String[] args){
        int[] a = {89, 24, 75, 11, 23};
        int[] b = {89, 2, 4};
        int answer = intersectionCount(a, b);
        System.out.println(answer);
    }

    private static int intersectionCount(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        int count = 0;
        while(i<a.length && j<b.length){
            if(a[i]==b[j]){
                count++;
                i++;
                j++;
            }
            else if(a[i] < b[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return count;
    }
}
