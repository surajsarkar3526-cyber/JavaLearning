package ArrayList_2DArray;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(lexicalOrder(n));
    }

    private static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int current = 1;
        for(int i=0; i<n; i++){
            result.add(current);
            if(current*10 <= n){
                current *= 10;
            }
            else{
                while(current%10 == 9 || current+1 > n){
                    current /= 10;
                }
                current++;
            }
        }
        return result;
    }
}
