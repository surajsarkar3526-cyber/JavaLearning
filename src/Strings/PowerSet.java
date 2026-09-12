package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PowerSet {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = "abcde";
        List<String> list = new ArrayList<>();
        StringSort("",s,0,list);
        System.out.println(list);
    }

    private static void StringSort(String ans, String s, int idx,List<String> list) {
        if(idx == s.length()){
            if(ans.length() != 0){
                list.add(ans);
            }
            return;
        }

        char ch = s.charAt(idx);
        StringSort(ans+ch,s,idx+1,list);
        StringSort(ans,s,idx+1,list);
    }
}
