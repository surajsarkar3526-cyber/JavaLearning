package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListBasics {
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(24);
        arr.add(21);
        arr.add(32);
        arr.add(14);
        arr.add(12);
        arr.add(9);
        arr.add(4);
        //System.out.println(arr.get(3));
//        arr.set(3,645);
//        System.out.println(arr);
//        arr.add(3,100);
//        System.out.println(arr);
//        Collections.reverse(arr);
//        arr.remove(3);
//        System.out.println(arr);
        int i = 0, j = arr.size()-1;
        while(i<j){
            int temp = arr.get(i);
            arr.set(i,arr.get(j));
            arr.set(j,temp);
            i++;
            j--;
        }
        for(int ele : arr){
            System.out.print(ele +" ");
        }
    }
}
