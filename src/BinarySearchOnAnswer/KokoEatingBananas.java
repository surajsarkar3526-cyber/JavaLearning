package BinarySearchOnAnswer;

public class KokoEatingBananas {

    static int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = getMax(piles);

        int answer = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canEat(piles, h, mid)) {
                answer = mid;
                right = mid - 1;
            }

            else {
                left = mid + 1;
            }
        }

        return answer;
    }

    static boolean canEat(int[] piles, int h, int speed) {

        int hours = 0;

        for (int bananas : piles) {
            hours += (bananas + speed - 1) / speed;
        }

        return hours <= h;
    }

    static int getMax(int[] piles) {

        int max = piles[0];

        for (int bananas : piles) {
            if (bananas > max) {
                max = bananas;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] piles = {3, 6, 7, 11};
        int h = 8;

        int result = minEatingSpeed(piles, h);

        System.out.println("Minimum Eating Speed = " + result);
    }
}
