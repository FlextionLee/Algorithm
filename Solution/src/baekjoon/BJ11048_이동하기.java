package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11048_이동하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][m];
        dp[0][0] = map[0][0];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int val1 = 0;
                int val2 = 0;
                int val3 = 0;
                if(i-1 >= 0){
                    val1 = dp[i-1][j];
                }
                if(j-1 >= 0){
                    val2 = dp[i][j-1];
                }
                if(j-1>=0 && i-1>=0){
                    val3 = dp[i-1][j-1];
                }
                dp[i][j] = Math.max(Math.max(val1,val2),val3) + map[i][j];
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
