package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ4179_불 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static char[][] map;
    static boolean[][] visited;
    static int sx,sy,N,M;
    static ArrayList<int[]> fire;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        N = n;
        M = m;
        map = new char[n][m];
        fire = new ArrayList<>();
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'J'){
                    sx = i;
                    sy = j;
                }
                if(map[i][j] == 'F'){
                    fire.add(new int[]{i,j});
                }
            }
        }
        visited = new boolean[n][m];
        int ans = bfs();
        if(ans <= 0){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println(ans);
        }
    }

    private static int bfs() {
        visited[sx][sy] = true;
        boolean[][] fed = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx,sy,0,0});
        for(int[] f : fire){
            q.add(new int[]{f[0],f[1],0,1});
            fed[f[0]][f[1]]=true;
        }
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[3] == 0){
                for(int d=0; d<4; d++){
                    int nx = tmp[0] + dx[d];
                    int ny = tmp[1] + dy[d];
                    if(nx<0||ny<0||nx>=N||ny>=M){
                        return tmp[2]+1;
                    }
                    if(visited[nx][ny]||map[nx][ny]=='F'||map[nx][ny]=='#')continue;
                    boolean ch = true;
                    for(int i=0; i<4; i++){
                        int nnx = nx+dx[i];
                        int nny = ny+dy[i];
                        if(nnx<0||nny<0||nnx>=N||nny>=M) continue;
                        if(map[nnx][nny] == 'F') ch = false;
                    }
                    if(ch){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx,ny,tmp[2]+1,0});
                    }
                }
            }else{
                for(int d=0; d<4; d++) {
                    int nx = tmp[0] + dx[d];
                    int ny = tmp[1] + dy[d];
                    if(nx<0||ny < 0||nx>= N||ny >= M||fed[nx][ny]||map[nx][ny]=='#') continue;
                    map[nx][ny] = 'F';
                    fed[nx][ny] = true;
                    q.add(new int[]{nx,ny,tmp[2]+1,1});
                }
            }
        }
        return -1;
    }
}
