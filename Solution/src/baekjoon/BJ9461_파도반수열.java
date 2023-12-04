package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ9461_파도반수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] idx = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            idx[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, idx[i]);
        }

        long[] dp = new long[max+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<=max; i++){
            dp[i] = dp[i-3] + dp[i-2];
        }

        for(int i=0; i<n; i++){
            System.out.println(dp[idx[i]-1]);
        }

    }
}
