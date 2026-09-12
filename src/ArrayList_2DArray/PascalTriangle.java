package ArrayList_2DArray;

import java.util.ArrayList;
import java.util.*;

public class PascalTriangle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enetr the Number : ");
        int n = sc.nextInt();

        ArrayList <ArrayList<Integer>> arr = new ArrayList<>();

        for(int i=0; i<n; i++){

            ArrayList<Integer> row = new ArrayList<>();

            for(int j=0; j<=i; j++){

                if(j == 0 || j == i){
                    row.add(1);
                }

                else{
                    row.add(arr.get(i-1).get(j)
                    + arr.get(i-1).get(j-1));
                }
            }

            arr.add(row);
        }

        for(ArrayList<Integer> list : arr){

            for(int ele : list){
                System.out.print(ele + " ");
            }

            System.out.println();
        }
    }
}
