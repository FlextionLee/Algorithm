package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class SW4193_수영대회결승전 {
    static int T,N,sx,sy,tx,ty,ans;
    static int[][] map;
    static boolean[][] visited;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            StringTokenizer st= new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            st= new StringTokenizer(br.readLine());
            tx = Integer.parseInt(st.nextToken());
            ty = Integer.parseInt(st.nextToken());
            ans = -1;
            bfs(sx,sy);
            System.out.println("#"+t+" "+ans);
        }
    }

    private static void bfs(int sx, int sy) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
        visited = new boolean[N][N];

        if(map[sx][sy]==2){
            q.add(new int[]{sx,sy,2});
            visited[sx][sy] = true;
        }
        else{
            q.add(new int[]{sx,sy,0});
            visited[sx][sy] = true;
        }

        while(!q.isEmpty()){
            int tmp[] = q.poll();
            if(tmp[0]==tx&&tmp[1]==ty){
                ans = tmp[2];
                return;
            }

            for(int i=0; i<4; i++){
                int nx = tmp[0]+dx[i];
                int ny = tmp[1]+dy[i];

                if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny]||map[nx][ny]==1) continue;
                if(map[nx][ny] == 2){
                    if(tmp[2]%3 == 2){
                            q.add(new int[] {nx,ny,tmp[2]+1});
                            visited[nx][ny]=true;

                    }
                    else{
                        if(tmp[2] + 2 - (tmp[2] % 3) + 1 < N*N){
                            q.add(new int[]{nx, ny, tmp[2] + 2 - (tmp[2] % 3) + 1});
                            visited[nx][ny] = true;
                        }
                    }
                }
                else{
                        q.add(new int[]{nx, ny, tmp[2] + 1});
                        visited[nx][ny] = true;
                }
            }

        }

    }
}
