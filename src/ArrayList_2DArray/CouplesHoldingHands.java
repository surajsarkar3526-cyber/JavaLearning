package ArrayList_2DArray;

public class CouplesHoldingHands {
    public static void main(String[] args) {
        int[] row = {0, 2, 1, 3};
        System.out.println(minSwapsCouples(row));
    }

    private static int minSwapsCouples(int[] row) {
        int n =  row.length;
        int swap = 0;
        for(int i=0; i<n; i+=2){
            int first = row[i];
            int partner = first ^ 1;
            if(row[i+1] != partner){
                for(int j=i+2; j<n; j++){
                    if(row[j] == partner){
                        int temp = row[i+1];
                        row[i+1] =  row[j];
                        row[j] = temp;
                        swap++;
                        break;
                    }
                }
            }
        }
        return swap;
    }
}
