package Arrays;

public class EquilibriumPoint {
    public static void main(String[] args){
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        int answer = findEquilibrium(arr);
        System.out.println("Equilibrium Point: " + answer);
    }

    private static int findEquilibrium(int[] arr) {
        int totalSum = 0;
        for(int num : arr){
            totalSum += num;
        }
        int leftSum = 0;
        for(int i=0; i<arr.length; i++){
            int rightSum = totalSum - leftSum - arr[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }
}
