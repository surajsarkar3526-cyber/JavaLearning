package CyclicSort;

import java.util.ArrayList;

public class ArrayDuplicates {
    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        ArrayList<Integer> duplicates = findDuplicates(nums);

        System.out.println("Duplicates: " + duplicates);
    }

    private static ArrayList<Integer> findDuplicates(int[] nums) {
        int i =0;
        ArrayList<Integer> result = new ArrayList<>();
        while(i < nums.length){
            int currentIndex = nums[i] - 1;
            if(nums[i] != nums[currentIndex]){
                int temp = nums[i];
                nums[i] = nums[currentIndex];
                nums[currentIndex] = temp;
            }
            else{
                i++;
            }
        }
        for(int j=0; j<nums.length; j++){
            if(nums[j] != j + 1){
                result.add(nums[j]);
            }
        }
        return result;
    }
}
