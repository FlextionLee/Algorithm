package baekjoon;

import com.sun.management.UnixOperatingSystemMXBean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BJ10026_적록색약 {
    static int N,A,B;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N;j++){
                if(visited[i][j]){
                    continue;
                }
                bfs(i,j);
                A++;
            }
        }

        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N;j++){
                if(visited[i][j]){
                    continue;
                }
                bfs2(i,j);
                B++;
            }
        }
        System.out.println(A+" "+B);

    }

    private static void bfs2(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {i,j});
        visited[i][j] =true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int k=0; k<4; k++){
                int nx = tmp[0]+dx[k];
                int ny = tmp[1]+dy[k];

                if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny]){
                    continue;
                }

                if(map[i][j] == map[nx][ny] || (map[i][j] == 'G' && map[nx][ny]=='R') ||  (map[i][j] == 'R' && map[nx][ny]=='G')){
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {i,j});
        visited[i][j] =true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int k=0; k<4; k++){
                int nx = tmp[0]+dx[k];
                int ny = tmp[1]+dy[k];

                if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny]){
                    continue;
                }

                if(map[i][j] == map[nx][ny]){
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
