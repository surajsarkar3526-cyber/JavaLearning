package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 1, 3, 2};
        System.out.println(majorityElement(nums));
    }
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int num : nums){
            if(num == candidate1){
                count1++;
            }
            else if(num == candidate2){
                count2++;
            }
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }
            else if(count2 == 0){
                candidate2 = num;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        int count3 = 0;
        int count4 = 0;
        for(int num : nums){
            if(num == candidate1){
                count3++;
            }
            else if(num == candidate2){
                count4++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if(count3 > n/3){
            result.add(candidate1);
        }
        if(count4 > n/3){
            result.add(candidate2);
        }
        return result;
    }
}
