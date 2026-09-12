package Arrays;

import java.util.ArrayList;

public class DuplicatesInLimitedRangeArray {
    public static void main(String[] args){
        int[] arr = {2,3,1,2,3};
        ArrayList<Integer> result = findDuplicates(arr);
        System.out.println(result);
    }
    private static ArrayList<Integer> findDuplicates(int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<=arr.length-1; i++){
            int index = Math.abs(arr[i])-1;
            if(arr[index] < 0){
                answer.add(arr[i]);
            }
            else{
                arr[index] = -arr[index];
            }
        }
        return answer;
    }
}
