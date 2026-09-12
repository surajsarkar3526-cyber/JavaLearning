package Strings;

public class MostFrequrncyCharacter {
    public static void main(String[] args){
         String str = "PROGRAMMING";

         int maxCount = 0;
         char maxChar = ' ';

         for(int i=0; i<str.length(); i++){

             int count = 0;

             for(int j=0; j<str.length(); j++){
                 if(str.charAt(i) == str.charAt(j)){
                     count++;
                 }
             }

             if(count > maxCount){
                 maxCount = count;
                 maxChar = str.charAt(i);
             }

         }

         System.out.println("Most Frequency Character is : " + maxChar);
         System.out.println("Max Frequency is : " + maxCount);
    }
}