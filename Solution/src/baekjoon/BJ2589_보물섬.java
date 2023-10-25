package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2589_보물섬 {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int N,M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        N = n;
        M = m;
        for(int i=0; i<n; i++){
            map[i] = br.readLine().toCharArray();
        }
        int max = Integer.MIN_VALUE;
        int sx = 0;
        int sy = 0;
        int tx = 0;
        int ty = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 'L' && !visited[i][j]){
                    int[] ret = bfs(i,j);
                    if(ret[2] > max){
                        int[] start = getEnd(i,j);
                        sx = start[0];
                        sy = start[1];
                        int[] end = getEnd(sx,sy);
                        tx = end[0];
                        ty = end[1];
                        max = ret[2];
                    }
                }
            }
        }

        visited = new boolean[n][m];
        int ans = bfs2(sx,sy,tx,ty);
        System.out.println(ans);
    }
    public static int[] getEnd(int i, int j){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j});
        boolean[][] visit = new boolean[N][M];
        visit[i][j] = true;
        int[] ret = new int[2];
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            ret = tmp;

            for(int d=0; d<4; d++){
                int nx = tmp[0]+dx[d];
                int ny = tmp[1]+dy[d];
                if(nx<0||ny<0||nx>=N||ny>=M||map[nx][ny] =='W'||visit[nx][ny]) continue;
                visit[nx][ny] = true;
                q.add(new int[]{nx,ny});
            }
        }
        return ret;
    }
    public static int bfs2(int sx,int sy, int tx, int ty){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx,sy,0});
        visited[sx][sy] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[0] == tx  && tmp[1] == ty) {
                return tmp[2];
            }
            for(int d=0; d<4; d++){
                int nx = tmp[0]+dx[d];
                int ny = tmp[1]+dy[d];
                if(nx<0||ny<0||nx>=N||ny>=M||map[nx][ny] =='W'||visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny,tmp[2]+1});
            }
        }
        return -1;
    }
    private static int[] bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j,1});
        visited[i][j] = true;
        int count = 0;
        int tx = 0;
        int ty = 0;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            count++;
            tx = tmp[0];
            ty = tmp[1];
            for(int d=0; d<4; d++){
                int nx = tmp[0]+dx[d];
                int ny = tmp[1]+dy[d];
                if(nx<0||ny<0||nx>=N||ny>=M||map[nx][ny] =='W'||visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny,tmp[2]+1});
            }
        }
        return new int[]{tx,ty,count};
    }
}
