package Stacks;

import java.util.*;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {

        if(matrix.length == 0)
            return 0;

        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxArea = 0;

        for (char[] row : matrix) {

            for (int j = 0; j < cols; j++) {

                if (row[j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        int n = heights.length;
        for(int i = 0; i <= n; i++) {


            int currentHeight;

            if (i == n) {
                currentHeight = 0;
            }
            else{
                currentHeight = heights[i];

            }
            while(!stack.isEmpty() &&
                    currentHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];
                int width;

                if(stack.isEmpty()) {
                    width = i;
                }
                else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        System.out.println(maximalRectangle(matrix));
    }
}
