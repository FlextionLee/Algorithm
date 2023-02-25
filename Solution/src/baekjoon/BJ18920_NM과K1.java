package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18920_NM과K1 {
    static int N,M,K,ans;
    static int map[][];
    static boolean visited[][];
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = Integer.MIN_VALUE;
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,0,0);
        System.out.println(ans);
    }

    private static void dfs(int depth, int sum, int r, int c) {
        if(depth == K){
            ans = Math.max(ans,sum);
            return;
        }
        else{
            for(int i=r; i<N; i++){
                for(int j=c; j<M; j++){
                    if(!visited[i][j]){
                        if(check(i,j)){
                            visited[i][j] = true;
                            dfs(depth+1,sum+map[i][j] , r, c);
                            visited[i][j] = false;
                        }
                    }
                }
            }
        }
    }

    private static boolean check(int r, int c) {
        boolean ch = true;
        for(int i=0; i<4; i++){
            int nx = r+dx[i];
            int ny = c+dy[i];

            if(nx<0||ny<0||nx>=N||ny>=M)continue;
            if(visited[nx][ny]) return false;
        }
        return true;
    }

}
