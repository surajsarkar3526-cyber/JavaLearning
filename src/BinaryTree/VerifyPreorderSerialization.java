package BinaryTree;

public class VerifyPreorderSerialization {
    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(isValidSerialization("1,#"));
        System.out.println(isValidSerialization("9,#,#,1"));
    }

    private static boolean isValidSerialization(String s) {
        String[] nums = s.split(",");
        int slots = 1;
        for(String num : nums){
            if(slots == 0){
                return false;
            }
            if(num.equals("#")){
                slots--;
            }
            else{
                slots = slots - 1 + 2;
            }
        }
        return slots == 0;
    }
}
