package Strings;

public class ReverseStrBldrs {
    public static void main(String[] args){
        String s = "Devansh";
        StringBuilder sb = new StringBuilder(s);
        int i = 0, j = sb.length()-1;
        while(i <= j){
            char temp1 = sb.charAt(i);
            char temp2 = sb.charAt(j);
            sb.setCharAt(i, temp2);
            sb.setCharAt(j, temp1);
            i++;
            j--;
        }
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        sb.deleteCharAt(1);
        System.out.println(sb);
        sb.insert(1,'e');
        System.out.println(sb);
//        sb.delete(2,5);
//        System.out.println(sb + " "+ sb.length());
        String s1 = sb.toString();
        System.out.println(s1);
    }
}
