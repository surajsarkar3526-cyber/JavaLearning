package Arrays;

public class MinimumDistance {
    public static void main(String[] args){
        int[] arr = {1,2,3,2};
        int x = 1;
        int y = 2;

        int answer = minDist(arr, x, y);
        System.out.println("Minimum Distance : " + answer);
    }

    private static int minDist(int[] arr, int x, int y) {
        int lastX = -1;
        int lastY = -1;
        int minDistance = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == x){
                lastX = i;
            }
            if(arr[i] == y){
                lastY = i;
            }
            if(lastX != -1 && lastY != -1){
                minDistance = Math.min(minDistance, Math.abs(lastX-lastY));
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}
