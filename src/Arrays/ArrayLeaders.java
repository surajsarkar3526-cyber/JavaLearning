package Arrays;
import java.util.ArrayList;
public class ArrayLeaders {
    public static void main(String[] args) {
        int[] arr = {16, 17, 3, 4, 5, 2};
        ArrayList<Integer> result = leaders(arr);
        System.out.println(result.toString());
    }

    private static ArrayList<Integer> leaders(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int maxNum = arr[arr.length - 1];
        result.add(maxNum);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > maxNum) {
                result.add(arr[i]);
                maxNum = arr[i];
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            answer.add(result.get(i));
        }
        return answer;
    }
}
