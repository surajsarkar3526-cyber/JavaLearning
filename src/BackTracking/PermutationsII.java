package BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class PermutationsII {
    public static void main(String[] args) {
        PermutationsII solution = new PermutationsII();
        int[] nums = {1, 1, 2};
        System.out.println(solution.permuteUnique(nums));
    }

    private List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backTrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i]){
                continue;
            }
            if(i>0 &&
            nums[i] == nums[i-1] &&
                    !used[i-1]){
                continue;
            }
            current.add(nums[i]);
            used[i] = true;
            backTrack(nums,used,current,result);
            current.removeLast();
            used[i] = false;
        }
    }
}