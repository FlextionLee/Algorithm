package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ17484_진우의달여행 {
    static int[][] map;
    static int ans;
    static int[] dx = {1,1,1};
    static int[] dy = {-1,0,1};
    static int N,M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        N = n;
        M = m;
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            dfs(1,-1,map[0][i],0, i);
        }
        System.out.println(ans);
    }

    private static void dfs(int depth, int prev, int sum,int x, int y) {
        if(sum > ans){
            return;
        }
        if(depth == N){
            ans = Math.min(ans,sum);
            return;
        }
        for(int i=0; i<3; i++){
            if(i == prev) continue;
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0||ny<0||nx>=N||ny>=M) continue;
            dfs(depth+1, i, sum+map[nx][ny],nx,ny);
        }
    }
}
