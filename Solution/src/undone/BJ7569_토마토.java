package undone;

import java.util.*;
import java.io.*;

public class BJ7569_토마토 {
    static int N,M,H;
    static boolean[][][] visited;
    static int[][][] map;
    static int dh[] = {-1,1};
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        int[][] tmp = new int[N][M];
        map = new int[H][N][M];
        visited = new boolean[H][N][M];

        int sum = 0;
        for(int i=0; i<N; i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                tmp[i][j] = Integer.parseInt(st.nextToken());
                sum += tmp[i][j];
            }
        }

        int count = 0;
        //모두 익은 상황
        if(sum == N*M){
            System.out.println(0);
            return;
        }

        if(sum == (N*M)*-1){
            System.out.println(-1);
            return;
        }

        //3차원 배열 초기화
        for(int i=0; i<H; i++){
            map[i] = tmp;
        }

        for(int h=0; h<H; h++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[h][i][j] == 1 && !visited[h][i][j]){
                        BFS(h,i,j);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);

    }

    private static void BFS(int h,int x,int y) {
        Queue<int[] > q= new ArrayDeque<>();
        q.add(new int[]{h,x,y});
        visited[h][x][y] = true;

        for(int t=0; t<2; t++){
            for(int k=0; k<4; k++){
                int[] tmp = q.poll();
                int nh = tmp[0]+dh[t];
                int nx = tmp[1]+dx[k];
                int ny = tmp[2]+dy[k];

                if(nh<0||nh>=H||nx<0||nx>=N||ny<0||ny>=M||visited[nh][nx][ny]||map[nh][nx][ny]==-1||map[nh][nx][ny]==1){
                    continue;
                }
                map[nh][nx][ny] = 1;
                q.add(new int[] {nh,nx,ny});
                visited[nh][nx][ny] = true;
            }
        }
    }
}
