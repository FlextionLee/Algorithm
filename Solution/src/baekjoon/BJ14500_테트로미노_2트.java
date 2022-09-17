package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14500_테트로미노_2트 {
    /**
     * ㅗ 모양을 제외한 나머지 모양은 dfs를 돌리면서 나올 수 있는 모양들
     */
    static int N,M,ans = Integer.MIN_VALUE;
    static int map[][];
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
              map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                dfs(i,j,0,map[i][j]);
                visited[i][j] = false;
                check(i,j);
            }
        }
        System.out.println(ans);
    }

    private static void check(int i, int j) {
        int sum = map[i][j];
        int count = 0;
        int min = Integer.MAX_VALUE;

        for(int k=0; k<4; k++){
            int nx = i+dx[k];
            int ny = j+dy[k];

            if(nx<0||ny<0||nx>=N||ny>=M) continue;
            min = Math.min(map[nx][ny],min);
            count++;
            sum += map[nx][ny];
        }

        if(count < 3){
            return;
        }
        else if(count == 3){
            ans = Math.max(ans,sum);
        }
        else if(count == 4){
            ans = Math.max(ans, sum - min);
        }
    }

    //ㅗ모양을 제외한 나머지 모양 처리해주기
    private static void dfs(int i, int j, int depth, int sum) {
        if(depth == 3){
            ans = Math.max(sum,ans);
            return;
        }

        for(int k=0; k<4; k++){
            int nx = i+dx[k];
            int ny = j+dy[k];
            if(nx<0||ny<0||nx>=N||ny>=M||visited[nx][ny]) continue;
            visited[nx][ny] = true;
            dfs(nx,ny,depth+1,sum+map[nx][ny]);
            visited[nx][ny] =false;
        }
    }
}
