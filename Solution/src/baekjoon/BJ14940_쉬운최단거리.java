package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14940_쉬운최단거리 {
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] ans;
    static int n,m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        int sx = 0;
        int sy = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    sx = i;
                    sy = j;
                }
            }
        }
        ans = new int[n][m];
        bfs(sx,sy);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(ans[i][j]==0){
                    if(map[i][j] == 1 && ans[i][j] == 0){
                        System.out.print(-1+" ");
                        continue;
                    }
                }
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void bfs(int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx,sy,0});
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[sx][sy] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny]) continue;;
                if(map[nx][ny]==0) continue;;
                visited[nx][ny] = true;
                q.add(new int[] {nx,ny,tmp[2]+1});
                ans[nx][ny] = tmp[2]+1;
            }
        }
    }
}
