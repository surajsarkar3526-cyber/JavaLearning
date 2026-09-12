package ArrayList_2DArray;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class SpirallyTraversingMatrix {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1,2,3,4)),
                new ArrayList<>(Arrays.asList(5,6,7,8)),
                new ArrayList<>(Arrays.asList(9,10,11,12)),
                new ArrayList<>(Arrays.asList(13,14,15,16))
        ));

        System.out.print("Enter Target Element : ");
        int target = sc.nextInt();

       System.out.print(Matrix(matrix));
    }

    private static ArrayList<Integer> Matrix(ArrayList<ArrayList<Integer>> matrix) {

        ArrayList<Integer> ans = new ArrayList<>();

        int top = 0;
        int buttom = matrix.size() - 1;

        int left = 0;
        int right = matrix.get(0).size()-1;

        while(top <= buttom && left <= right){

            for(int col = left; col <= right; col++){
                ans.add(matrix.get(top).get(col));
            }
            top++;

            for(int row = top; row <= buttom; row++){
                ans.add(matrix.get(row).get(right));
            }
            right--;

            if(top <= buttom){

                for(int col = right; col >= left; col--){
                    ans.add(matrix.get(buttom).get(col));
                }
                buttom--;

            }
            if(left <= right){

                for(int row = buttom; row >= top; row--){
                    ans.add(matrix.get(row).get(left));
                }
                left++;
            }
        }
        return ans;
    }
}