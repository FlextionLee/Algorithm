package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW7793_오나의여신님2트 {
    static int T,N,M,sx,sy,tx,ty,ans;
    static char[][] map;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};
    static  Queue<int[]> q;
    static int[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            q = new ArrayDeque<>();
            map = new char[N][M];
            visited = new int[N][M];
            ans = 0;
            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<M; j++){
                    map[i][j] =str.charAt(j);
                    if(map[i][j] == '*'){
                        q.add(new int[] {i,j,0,1});
                        visited[i][j] = 1;
                    }
                    else if(map[i][j] == 'S'){
                        sx = i;
                        sy = j;
                    }
                    else if(map[i][j] == 'D'){
                        tx = i;
                        ty = j;
                    }
                }
            }

            bfs(sx,sy);
            if(ans == 0){
                System.out.println("#"+t+" GAME OVER");
            }
            else{
                System.out.println("#"+t+" "+ans);
            }
        }

    }

    private static void bfs(int sx, int sy) {
        q.add(new int[] {sx,sy,0,2});
        visited[sx][sy] = 2;

        while(!q.isEmpty()){
            int tmp[] = q.poll();
            if(tmp[3] == 2 && tmp[0] == tx && tmp[1] == ty){
                ans = tmp[2];
                return;
            }

            for(int i=0; i<4; i++){
                int nx = tmp[0] +dx[i];
                int ny = tmp[1]+dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M) continue;
                if(tmp[3]==2){
                    if((map[nx][ny] == '.'|| map[nx][ny] == 'D') && visited[nx][ny]==0){
                        q.add(new int[] {nx,ny,tmp[2]+1,tmp[3]});
                        visited[nx][ny] = 2;
                    }
                }
                else{
                    if(map[nx][ny] != 'X' && visited[nx][ny] != 1 && map[nx][ny] != 'D'){
                        q.add(new int[] {nx,ny,tmp[2]+1,tmp[3]});
                        visited[nx][ny] = 1;
                    }
                }
            }

        }
    }
}
