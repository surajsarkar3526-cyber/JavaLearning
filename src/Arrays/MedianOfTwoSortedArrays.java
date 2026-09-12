package Arrays;

public class MedianOfTwoSortedArrays {
    static void main() {
        int[] a = {3, 5, 6, 12, 15};
        int[] b = {3, 4, 6, 10, 10, 12};
        System.out.println(findMedian(a, b));
    }

    private static double findMedian(int[] a, int[] b) {
        if(a.length > b.length){
            return findMedian(b, a);
        }
        int n = a.length;
        int m = b.length;
        int low = 0;
        int high = n;
        int leftSize = (n + m + 1)/2;
        while(low <= high){
            int cutA = (low + high)/2;
            int cutB = leftSize - cutA;
            int leftA = (cutA == 0)? Integer.MIN_VALUE : a[cutA-1];
            int rightA = (cutA == n)? Integer.MAX_VALUE : a[cutA];
            int leftB = (cutB == 0)? Integer.MIN_VALUE : b[cutB-1];
            int rightB = (cutB == m)? Integer.MAX_VALUE : b[cutB];
            if(leftA <= rightB && leftB <= rightA){
                if((n+m)%2 == 1){
                    return Math.max(leftA, leftB);
                }
                else{
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                }
            }
            if(leftA > rightB){
                high = cutA - 1;
            }
            else{
                low = cutA + 1;
            }
        }
        return 0.0;
    }
}
