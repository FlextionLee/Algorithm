package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class BJ5557_1학년 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] map = new int[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        int last = Integer.parseInt(st.nextToken());
        long[][] dp = new long[n-1][21];
        dp[0][map[0]] = 1;
        for(int i=1; i<n-1; i++){
            int val = map[i];
            for(int j=0; j<=20; j++){
                if(dp[i-1][j] > 0){
                    int tmp = j;
                    if(tmp + val >= 0 && tmp+val <=20){
                        dp[i][tmp+val] += dp[i-1][j];
                    }
                    if(tmp - val >=0 && tmp-val <=20){
                        dp[i][tmp-val] += dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[n-2][last]);
    }
}
