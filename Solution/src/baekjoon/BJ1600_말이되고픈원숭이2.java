package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1600_말이되고픈원숭이2 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[] hy = {-2,-2,-1,-1,1,1,2,2};
    static int[] hx = {-1,1,-2,2,2,-2,1,-1};
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(n,m,k));
    }
    public static int bfs(int n,int m, int k){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[n][m][k+1];
        q.add(new int[]{0,0,0,0});
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[0] == n-1 && tmp[1] == m-1) return tmp[2];

            if(tmp[3] < k){
                for(int i=0; i<8; i++){
                    int nx = tmp[0] + hx[i];
                    int ny = tmp[1] + hy[i];
                    if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny][tmp[3]+1]||map[nx][ny]==1) continue;
                    q.add(new int[]{nx,ny,tmp[2]+1, tmp[3]+1});
                    visited[nx][ny][tmp[3]+1] = true;
                }
            }
            for(int i=0; i<4; i++){
                int nx = tmp[0]+dx[i];
                int ny = tmp[1]+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny][tmp[3]]||map[nx][ny] == 1)continue;
                q.add(new int[]{nx,ny,tmp[2]+1,tmp[3]});
                visited[nx][ny][tmp[3]] = true;
            }
        }
        return -1;
    }
}
