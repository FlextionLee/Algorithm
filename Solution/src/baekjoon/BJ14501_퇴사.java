package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14501_퇴사 {
    static int N;
    static int[][] map;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N+100][N+100];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }


        for(int i=1; i<=N; i++){
            for(int j=1;j <=N; j++){
               if(map[i][j] != 0 ){
                   dfs(i,j,map[i][j]);
               }
            }
        }
       System.out.println(max);

    }
    private static void dfs(int n,int m,int sum){
        if(n+m > N+1 ){
            max = Math.max(sum-map[n][m], max);
            return;
        }
        if(n+m == N+1){
            max = Math.max(sum, max);
            return;
        }

        for(int i=n+m; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(map[i][j] != 0){
                    dfs(i,j,sum+map[i][j]);
                }
            }
        }
    }
}
