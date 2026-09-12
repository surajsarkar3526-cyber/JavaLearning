package CyclicSort;

public class SmallestPositiveMissing {
    public static void main(String[] args) {

        int[] arr = {2, -3, 4, 1, 1, 7};

        int missing = findSmallestMissing(arr);

        System.out.println("Smallest Positive Missing: " + missing);
    }

    private static int findSmallestMissing(int[] arr) {
        int i =0;
        while(i<arr.length) {
            if (arr[i] > 0 &&
                    arr[i] <= arr.length) {
                int currentIndex = arr[i] - 1;
                if (arr[i] != arr[currentIndex]) {

                    int temp = arr[i];
                    arr[i] = arr[currentIndex];
                    arr[currentIndex] = temp;
                }
                else {
                    i++;
                }
            }
            else{
                i++;
            }
        }

        for(int j=0; j<arr.length; j++){
            if(arr[j] != j+1){
                return j + 1;
            }
        }

        return arr.length + 1;
    }
}
