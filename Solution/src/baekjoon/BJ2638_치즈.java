package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2638_치즈 {
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited;
    static int N,M;
    static Queue<int[]> q;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        N = n;
        M = m;
        visited = new boolean[n][m];
        q = new ArrayDeque<>();
        int count = 0;
        map[0][0] = 2;
        init(0,0);
        while(!q.isEmpty()){
            bfs();
            count++;
        }
        System.out.println(count);
    }
    public static void init(int x, int y ){
        Queue<int[]> candi = new ArrayDeque<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        boolean[][] visitedC = new boolean[N][M];
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            for(int d=0; d<4; d++){
                int nx = tmp[0] + dx[d];
                int ny = tmp[1] + dy[d];
                if(nx<0||ny<0||nx>=N||ny>=M||visited[nx][ny]) continue;
                if(map[nx][ny] == 0){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny,map[nx][ny]});
                    map[nx][ny] = 2;
                }
                if(map[nx][ny] == 1 && !visitedC[nx][ny]){
                    int count = 0;
                    for(int k=0; k<4; k++){
                        int nnx = nx + dx[k];
                        int nny = ny + dy[k];
                        if(nnx<0||nny<0||nnx>=N||nny>=M) continue;
                        if(map[nnx][nny]==2) count++;
                    }
                    if(count >= 2){
                        visitedC[nx][ny] = true;
                        candi.add(new int[]{nx,ny});
                    }
                }
            }
        }

        while(!candi.isEmpty()){
            int[] tmp = candi.poll();
            map[tmp[0]][tmp[1]] = 2;
            q.add(tmp);
        }
    }

    private static void bfs() {
        Queue<int[]> candi = new ArrayDeque<>();
        boolean[][] visitedC = new boolean[N][M];

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            for(int d=0; d<4; d++){
                int nx = tmp[0] + dx[d];
                int ny = tmp[1] + dy[d];
                if(nx<0||ny<0||nx>=N||ny>=M||visited[nx][ny]) continue;
                if(map[nx][ny] == 0){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny,map[nx][ny]});
                    map[nx][ny] = 2;
                }
                if(map[nx][ny] == 1 && !visitedC[nx][ny]){
                    int count = 0;
                    for(int k=0; k<4; k++){
                        int nnx = nx + dx[k];
                        int nny = ny + dy[k];
                        if(nnx<0||nny<0||nnx>=N||nny>=M) continue;
                        if(map[nnx][nny]==2) count++;
                    }
                    if(count >= 2){
                        visitedC[nx][ny] = true;
                        candi.add(new int[]{nx,ny});
                    }
                }
            }
        }

        while(!candi.isEmpty()){
            int[] tmp = candi.poll();
            map[tmp[0]][tmp[1]] = 2;
            q.add(tmp);
        }
    }
}
