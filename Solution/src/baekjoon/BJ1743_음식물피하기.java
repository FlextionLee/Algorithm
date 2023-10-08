package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1743_음식물피하기 {
    static int[][] map;
    static boolean[][] visited;
    static int ans = Integer.MIN_VALUE;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    int val = bfs(i,j,n,m);
                    ans = Math.max(val,ans);
                }
            }
        }
        System.out.println(ans);
    }

    private static int bfs(int i, int j,int n, int m) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;
        int val =0;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            val++;
            for(int d=0; d<4; d++){
                int nx = tmp[0] +dx[d];
                int ny = tmp[1] +dy[d];
                if(nx<0||ny<0||nx>n|ny>m||visited[nx][ny]||map[nx][ny] == 0) continue;
                q.add(new int[]{nx,ny});
                visited[nx][ny] = true;
            }
        }
        return val;
    }
}
