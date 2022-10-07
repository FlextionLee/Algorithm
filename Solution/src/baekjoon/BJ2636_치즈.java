package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2636_치즈 {
    static int N, M;
    static int[][] map;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    private static void bfs() {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0,0});
        visited[0][0] = true;

        Queue<int[]> nq = new ArrayDeque<>();

        int hour =0, prev =0;

        while(true){
            //bfs 완탐
           while(!q.isEmpty()){
               int[] tmp = q.poll();

               for(int k=0; k<4; k++){
                   int nx = tmp[0]+dx[k];
                   int ny = tmp[1]+dy[k];

                   if(nx<0||ny<0||nx>=N||ny>=M||visited[nx][ny])continue;
                   visited[nx][ny]=true;
                   if(map[nx][ny]==0){
                       q.add(new int[] {nx,ny});
                   }
                   else{
                       nq.add(new int[] {nx,ny});
                   }
               }
           }

            if(nq.isEmpty()){
                break;
            }
            else{
                prev = nq.size();
                hour++;
                System.out.println(prev);
                System.out.println(hour);

                Queue<int[]> temp = q;
                q = nq;
                nq = temp;
            }
        }
        System.out.println(hour);
        System.out.println(prev);

    }

}