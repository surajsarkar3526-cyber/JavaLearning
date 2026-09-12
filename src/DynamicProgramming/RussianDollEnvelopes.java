package DynamicProgramming;
import java.util.Arrays;
public class RussianDollEnvelopes {
    static int[] dp;
    static int solve(int[][] envelopes, int i){
        if(dp[i] != -1){
            return dp[i];
        }
        int maxlength = 1;
        for(int j=i+1; j<envelopes.length; j++){
            if(envelopes[j][0] > envelopes[i][0] &&
                    envelopes[j][1] > envelopes[i][1]){
                int result = solve(envelopes, j);
                maxlength = Math.max(maxlength, 1 + result);
            }
        }
        return dp[i] = maxlength;
    }
    public static void main(String[] args) {
        int[][] envelopes = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b)->{
            if(a[0] == b[0]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        dp = new int[n];
        Arrays.fill(dp, -1);
        int answer = 0;
        for(int i=0; i<n; i++){
            answer = Math.max(answer, solve(envelopes, i));
        }

        System.out.println("Maximum envelopes : " + answer);
    }
}
