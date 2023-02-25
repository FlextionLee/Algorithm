package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7733_치즈도둑 {
    static int T,N,ans,max;
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited;
    static Queue<int[]> q;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1 ;t<=T ;t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            max = Integer.MIN_VALUE;
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max,map[i][j]);
                }
            }

            ans = Integer.MIN_VALUE;
            q = new ArrayDeque<>();
            for(int k=1; k<=max; k++){
                visited = new boolean[N][N];
                int count = 0;
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(map[i][j] != 0 && !visited[i][j]){
                            visited[i][j] = true;
                            bfs(i,j);
                            count++;
                        }
                    }
                }
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(map[i][j] == k) map[i][j] = 0;
                    }
                }
                ans = Math.max(ans, count);
            }
            System.out.println("#"+t+" "+ans);
        }
    }
    private static void bfs(int j, int k) {
        q.add(new int[] {j,k});

        while(!q.isEmpty()) {
            int[] tmp = q.poll();

            for(int i=0; i<4; i++) {
                int nx = tmp[0]+dx[i];
                int ny = tmp[1]+dy[i];

                if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny]) continue;
                if(map[nx][ny] != 0) {
                    q.add(new int[] {nx,ny});
                    visited[nx][ny]=true;
                }
            }
        }
    }
}