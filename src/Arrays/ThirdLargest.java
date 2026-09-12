package Arrays;

public class ThirdLargest {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        int answer = thirdLargest(arr);
        System.out.println(answer);
    }

    private static int thirdLargest(int[] arr) {
        if(arr.length < 3){
            return -1;
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for(int num : arr){
            if(num >= first){
                third = second;
                second = first;
                first = num;
            }
            else if(num >= second){
                third = second;
                second = num;
            }
            else if(num >= third){
                third = num;
            }
        }
        return third;
    }
}
