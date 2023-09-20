package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206_벽부수고이동하기 {
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        N = n;
        M = m;
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,1,1});

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[0] == N-1 && tmp[1] == M-1){
                return tmp[2];
            }

            for(int i=0; i<4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M||visited[nx][ny][tmp[3]]) continue;
                if(map[nx][ny] == 1){
                    if(tmp[3] == 1){
                        visited[nx][ny][tmp[3]] = true;
                        q.add(new int[]{nx,ny,tmp[2]+1,0});
                    }
                }else{
                    visited[nx][ny][tmp[3]] = true;
                    q.add(new int[]{nx,ny,tmp[2]+1,tmp[3]});
                }
            }
        }
        return -1;
    }
}
