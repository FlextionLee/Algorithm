package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW1953_탈주범검거3트 {
    static int T,N,M,R,C,L,ans;
    static int map[][];
    //상 우 하 좌
    static boolean[][] dxy ={
            {},
            {true, true, true, true},
            {true, false, true, false},
            {false, true, false, true},
            {true, true, false, false,},
            {false, true, true, false},
            {false,false, true, true},
            {true,false,false,true}
    };
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            ans = 0;
            map = new int[N][M];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(R,C);
            System.out.println("#"+t+" "+ans);
        }
    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r,c,map[r][c],1});
        visited = new boolean[N][M];
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[3] <= L){
                ans++;
            }
            else{
                return;
            }
            for(int i=0; i<4; i++){
                if(dxy[tmp[2]][i]){
                    int nx = tmp[0]+dx[i];
                    int ny = tmp[1]+dy[i];
                    if(nx<0||ny<0||nx>=N||ny>=M||map[nx][ny]==0||visited[nx][ny]) continue;
                    if(dxy[map[nx][ny]][(i+2)%4]){
                        q.add(new int[] {nx,ny,map[nx][ny],tmp[3]+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
