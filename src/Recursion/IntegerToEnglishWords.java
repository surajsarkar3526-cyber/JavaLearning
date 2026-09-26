package Recursion;

public class IntegerToEnglishWords {
    String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public static void main(String[] args) {
        IntegerToEnglishWords obj = new IntegerToEnglishWords();
        int num = 1234567;
        String answer = obj.numberToWords(num);
        System.out.println(answer);
    }

    private String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder result = new StringBuilder();
        int billions = num / 1000000000;
        num = num % 1000000000;
        int million = num / 1000000;
        num = num % 1000000;
        int thousand = num / 1000;
        num = num % 1000;
        int reminder = num;
        if (billions > 0) {
            result.append(convertThreeDigits(billions)).append(" Billion");
        }
        if (million > 0) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(convertThreeDigits(million)).append(" Million");
        }
        if (thousand > 0) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(convertThreeDigits(thousand)).append(" Thousand");
        }
        if (reminder > 0) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(convertThreeDigits(reminder));
        }
        return result.toString();
    }

    private String convertThreeDigits(int num) {
        StringBuilder result = new StringBuilder();
        if(num >= 100){
            result.append(ones[num/100]).append(" Hundred");
            num = num % 100;
        }
        if(num >= 20){
            if(result.length() > 0){
                result.append(" ");
            }
            result.append(tens[num / 10]);
            num = num % 10;
        }
        if(num > 0){
            if(result.length() > 0){
                result.append(" ");
            }
            result.append(ones[num]);
        }

        return result.toString();
    }
}
