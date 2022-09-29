package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2468_안전영역 {
    static int N,max,ans=Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,map[i][j]);
            }
        }

        for(int k=0; k<max; k++){
            up(k);

            int count = 0;
            visited = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] != 101 && !visited[i][j]){
                        count++;
                        bfs(i,j);
                    }
                }
            }
            ans = Math.max(count, ans);
        }
        System.out.println(ans);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q= new ArrayDeque<>();
        visited[x][y] = true;
        q.add(new int[] {x,y});

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int k=0; k<4; k++){
                int nx = tmp[0] + dx[k];
                int ny = tmp[1] + dy[k];

                if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny]) continue;

                if(map[nx][ny] != 101){
                    q.add(new int[] {nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static void up(int k) {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]<=k){
                    map[i][j] = 101;
                }
            }
        }
    }
}
