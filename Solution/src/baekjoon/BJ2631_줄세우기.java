package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2631_줄세우기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        int dp[] = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i - 1; j >= 0; j--){
                System.out.println(i+" "+j);
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            max = Math.max(dp[i], max);
            }
        }
        System.out.println(N - max);
    }
}
