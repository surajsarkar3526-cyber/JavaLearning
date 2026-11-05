package MergeSort;

import java.util.ArrayList;
import java.util.List;

public class CountSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        List<Integer> result = countSmaller(nums);
        System.out.println(result);
    }
    static int[] index;
    static int[] count;
    static int[] temp;

    private static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        temp = new int[n];
        count = new int[n];
        index = new int[n];

        for(int i=0; i<n; i++){
            index[i] = i;
        }
        mergeSort(nums,0,n-1);
        List<Integer> result = new ArrayList<>();
        for (int count : count) {
            result.add(count);
        }

        return result;
    }
    public static void mergeSort(int[] arr, int start, int end) {
        if(start >= end){
            return;
        }
        int mid = start + (end - start)/2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        merge(arr, start, mid, end);
    }
    public static void merge(int[] nums, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;
        int rightSmaller = 0;
        while (i <= mid && j <= end) {

            if (nums[index[j]] < nums[index[i]]) {
                temp[k++] = index[j++];
                rightSmaller++;
            }
            else {
                count[index[i]] += rightSmaller;
                temp[k++] = index[i++];
            }
        }

        while (i <= mid) {
            count[index[i]] += rightSmaller;
            temp[k++] = index[i++];
        }

        while (j <= end) {
            temp[k++] = index[j++];
        }

        for (int p = start; p <= end; p++) {
            index[p] = temp[p];
        }
    }
}
