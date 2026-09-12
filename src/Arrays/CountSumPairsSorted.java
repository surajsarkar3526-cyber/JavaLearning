package Arrays;

public class CountSumPairsSorted {
    public static void main(String[] aargs){
        int[] arr = {-1, 1, 5, 5, 7};
        int target = 6;
        int answer = countPairs(arr, target);
        System.out.println(answer);
    }
    private static int countPairs(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int count = 0;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum < target){
                left++;
            }
            else if(sum > target){
                right--;
            }
            else{
                if(arr[left] == arr[right]){
                    int n = right-left+1;
                    count += n*(n-1)/2;
                    break;
                }
                int leftValue = arr[left];
                int leftCount = 0;
                while(left<=right && arr[left] == leftValue){
                    leftCount++;
                    left++;
                }
                int rightValue = arr[right];
                int rightCount = 0;
                while(left <= right && arr[right]==rightValue){
                    rightCount++;
                    right--;
                }
                count += leftCount * rightCount;
            }
        }
        return count;
    }
}
