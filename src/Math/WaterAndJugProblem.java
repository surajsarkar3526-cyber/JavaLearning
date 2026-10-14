package Math;

public class WaterAndJugProblem {
    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        int target = 4;
        WaterAndJugProblem solution = new WaterAndJugProblem();
        boolean result = solution.canMeasureWater(x, y, target);
        System.out.println(result);
    }

    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) {
            return false;
        }
        return target % gcd(x, y) == 0;
    }

    private int gcd(int x, int y) {
        while(y != 0){
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
