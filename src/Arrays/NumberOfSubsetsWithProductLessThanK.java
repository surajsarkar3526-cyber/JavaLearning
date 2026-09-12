package Arrays;

public class NumberOfSubsetsWithProductLessThanK {
    static void main(String[] args) {
        int[] arr = {2, 4, 5, 3};
        int k = 12;
        NumberOfSubsetsWithProductLessThanK obj = new NumberOfSubsetsWithProductLessThanK();
        System.out.println(obj.countSubsets(arr, k));
    }
    public int countSubsets(int[] arr, int k) {
        return solve(arr, 0, 1, k, false);
    }
    private int solve(int[] arr, int index, int product, int k, boolean taken) {
        if(index == arr.length){
            return taken && product <= k? 1 : 0;
        }
        int take = 0;
        if (product <= k / arr[index]) {
            take = solve(arr, index + 1, product * arr[index], k, true);
        }
        int noTake = solve(arr, index + 1, product, k, false);
        return take + noTake;
    }
}