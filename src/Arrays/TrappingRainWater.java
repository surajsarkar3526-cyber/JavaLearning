package Arrays;

public class TrappingRainWater {
    static void main() {
        int[] arr = {3, 0, 1, 0, 4, 0, 2};
        int result = trappingWater(arr);
        System.out.println("Water trapped = " + result);
    }
    private static int trappingWater(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        while(left <= right){
            if(arr[left] < arr[right]){
                if(arr[left] >= leftMax){
                    leftMax = arr[left];
                }
                else{
                    water += leftMax - arr[left];
                }
                left++;
            }
            else{
                if(arr[right] >= rightMax){
                    rightMax = arr[right];
                }
                else{
                    water += rightMax - arr[right];
                }
                right--;
            }
        }
        return water;
    }
}
