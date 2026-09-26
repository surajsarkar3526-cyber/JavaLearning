package BinaryTree;

public class CycleLengthQueriesInATree {
    public static void main(String[] args) {
        CycleLengthQueriesInATree obj = new CycleLengthQueriesInATree();
        int n = 3;
        int[][] queries = {
                {5, 3},
                {4, 7},
                {2, 3}
        };
        int[] result = obj.cycleLengthQueries(n, queries);
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    private int[] cycleLengthQueries(int n, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i=0; i< queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            int difference = 0;
            while(a != b){
                if(a>b){
                    a /= 2;
                }
                else{
                    b /= 2;
                }
                difference++;
            }
            answer[i] = difference;
        }
        return answer;
    }
}
