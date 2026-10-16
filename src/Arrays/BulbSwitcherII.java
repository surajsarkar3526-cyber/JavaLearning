package Arrays;

public class BulbSwitcherII {
    public static void main(String[] args) {
        System.out.println(flipLights(3, 1));
        System.out.println(flipLights(3, 2));
        System.out.println(flipLights(3, 3));
    }

    private static int flipLights(int n, int presses) {
        if(presses == 0){
            return 1;
        }
        if(n==1){
            return 2;
        }
        if(n==2){
            if(presses == 1){
                return 3;
            }
            return 4;
        }
        if(presses == 1){
            return 4;
        }
        if(presses == 2){
            return 7;
        }
        return 8;
    }
}
