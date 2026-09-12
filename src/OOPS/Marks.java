package OOPS;

import java.util.Arrays;
import java.util.Scanner;

public class Marks {
    public static class StudentData{
        String name;
        int rno;
        int[] marks;
        StudentData(){

        }
        StudentData(int[] s){
//            marks = s; //  Shallow Copy
            marks = Arrays.copyOf(s,s.length); //  ---> Deep Copy
//            System.out.println(marks.length-1);
        }
        StudentData(int s){
            marks = new int[s];
        }

        public void print() {
            for(int i=0; i<marks.length; i++){
                System.out.print(marks[i]+" ");
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = {5,3,6,8,5,8,6};
        StudentData s1 = new StudentData(arr);
        s1.marks[0] = 40;
        System.out.println(arr[0]);

        StudentData s3 = new StudentData(5);
        s3.marks[0] = 54;
        s3.marks[1] = 24;
        s3.marks[2] = 34;
        s3.marks[3] = 84;
        s3.marks[4] = 354;

        s3.print();

    }
}
