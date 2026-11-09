package SortingAlgorithms;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 3, 1, 7, 0, 10, 2};
        quickSort(arr, 0, arr.length - 1);
        for(int ele : arr){
            System.out.print(ele+" ");
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low < high){
            int partition = partitions(arr,low,high);
            quickSort(arr,low, partition);
            quickSort(arr, partition+1, high);
        }
    }

    private static int partitions(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for(int j=low; j<high; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i;
    }
}
