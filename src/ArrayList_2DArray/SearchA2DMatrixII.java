package ArrayList_2DArray;

public class SearchA2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int row = rows - 1;
        int column = 0;
        while(row >= 0 && column < columns){
            int current = matrix[row][column];
            if(current == target){
                return true;
            }
            else if(target > current){
                column++;
            }
            else{
                row--;
            }
        }
        return false;
    }
}
