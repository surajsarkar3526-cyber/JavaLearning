package Heap;
import java.util.Arrays;

class Heap{
    private int[] arr;
    private int idx = 1;
    int peek(){
        return arr[1];
    }
    int remove(){
        if(idx == 1){
            System.out.println("Heap is Empty!");
        }
        int min = arr[1];
        arr[1] = arr[idx-1];
        idx--;

        int root = 1;
        while(root <= size()){
            int left = 2*root;
            int right = 2*root+1;
            int leftVal = (left<=size()) ? arr[left] : Integer.MAX_VALUE;
            int rightVal = (right <= size()) ? arr[right] : Integer.MAX_VALUE;
            if(arr[root] < arr[left] && arr[root] < arr[right]){
                break;
            }
            else{
                int temp = arr[root];
                if(leftVal < rightVal){
                    arr[root] = arr[left];
                    arr[left] = temp;
                    root = left;
                }
                else{
                    arr[root] = arr[right];
                    arr[right] = temp;
                    root = right;
                }
            }
        }
        return min;
    }
    int size(){
        int size = idx - 1;
        return size;
    }
    void add(int ele){
        arr[idx++] = ele;

        int root = idx-1;
        while(root != 1){
            int parent = root/2;
            if(arr[root] < arr[parent]){
                int temp = arr[root];
                arr[root] = arr[parent];
                arr[parent] = temp;
                root /= 2;
                // root = parent
            }
            else{
                break;
            }
        }
    }
    void display(){
        for(int i=1; i<idx; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    Heap(int capacity){
        arr = new int[10];
        Arrays.fill(arr, Integer.MAX_VALUE);
    }
}
public class MinHeapImplementation {
    public static void main(String[] args) {
        Heap h = new Heap(10);
        h.add(10); h.add(15); h.add(8); h.add(9); h.add(4);
        h.display();
        System.out.println(h.remove());
        h.display();
        h.add(2);
        h.display();
        System.out.println(h.remove());
        h.display();
    }
}
