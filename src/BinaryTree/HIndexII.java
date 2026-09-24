package BinaryTree;

public class HIndexII {
    public static void main(String[] args) {
        int[] citation = {0,1,3,5,6};
        HIndexII obj = new HIndexII();
        int result = obj.hIndex(citation);
        System.out.println("H-Index = " + result);

    }
    private int hIndex(int[] citation) {
        int n = citation.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int paper = n - mid;
            if(citation[mid] >= paper){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return n - left;
    }
}
