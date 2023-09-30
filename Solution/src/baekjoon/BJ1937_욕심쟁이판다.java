package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1937_욕심쟁이판다 {
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N,ans;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        N = n;
        ans = Integer.MIN_VALUE;
        dp = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ans = Math.max(ans, dfs(i,j));
            }
        }
        System.out.println(ans);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int dfs(int x, int y) {
        if(dp[x][y] != 0){
            //이미 방문한 적이 있던 곳이라면 가지 않는다.
            return dp[x][y];
        }
        //자기 자신을 포함하는 초기화
        dp[x][y] = 1;

        for(int k=0; k<4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx<0||ny<0||nx>=N||ny>=N) continue;
            if(map[x][y] < map[nx][ny]){
                //4개 구간 중 최대값을 뽑아내는 상황
               dp[x][y] = Math.max(dp[x][y], dfs(nx,ny)+1);
            }
        }
        //최종적으로 최대값을 리턴해주는 상황
        return dp[x][y];
    }
}
