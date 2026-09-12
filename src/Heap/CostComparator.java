package Heap;

import java.util.Arrays;
import java.util.*;

class Student implements Comparable<Student>{
    String name;
    int rno;
    double cgpa;

    Student(String name, int rno, double cgpa){
        this.name = name;
        this.rno = rno;
        this.cgpa = cgpa;
    }

    public int compareTo(Student other) {
        return (int)(this.cgpa - other.cgpa);
    }
//    public int compareTo(Student other) {
//        return Integer.compare(this.rno, other.rno);
//    }
}
public class CostComparator {

    public static void main(String[] args) {
        Student s1 = new Student("Suraj", 200, 8.0);
        Student s2 = new Student("Abhimanyu",42, 7.9);
        Student s3 = new Student("Rajesh",31,8.9);
        Student s4 = new Student("Manu", 20, 8.7);
        Student s5 = new Student("Anand",48, 9.1);
        Student s6 = new Student("Rajendra",90,9.0);
        Student[] arr = {s1,s2,s3,s4,s5,s6};

         Arrays.sort(arr);

        for(Student s : arr){
            System.out.println(s.name+" "+s.rno+" "+s.cgpa);
        }
    }
}
