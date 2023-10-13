package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15681_트리와쿼리 {
    static ArrayList<Integer>[] list;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        dp = new int[n+1];
        for(int i=1 ;i<=n; i++){
            list[i] = new ArrayList<>();
        }
        Arrays.fill(dp,1);
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(r,-1);

        for(int i=0; i<q; i++){
            int idx = Integer.parseInt(br.readLine());
            System.out.println(dp[idx]);
        }
    }
    public static void dfs(int t, int val){
        dp[t] = 1;
        for(int i : list[t]){
            if(i == val) continue;
            dfs(i,t);
            dp[t] += dp[i];
        }
    }
}
