package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1303_전투 {
    static int N,M,W,B;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[M][N];
        visited = new boolean[M][N];

        for(int i=0;i<M;i++){
            String str = br.readLine();
            for(int j=0;j<N; j++){
                map[i][j] = str.charAt(j);
            }
        }
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]){
                    continue;
                }
                bfs(map[i][j],i,j);
            }
        }
        System.out.println(W+" "+B);
    }

    private static void bfs(char c,int i,int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {i,j});
        visited[i][j] = true;
        int count = 1;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int k=0; k<4; k++){
                int nx = tmp[0] + dx[k];
                int ny = tmp[1] + dy[k];

                if(nx < 0 || nx >=M || ny <0 || ny>=N || visited[nx][ny] || map[nx][ny] !=c ) {
                    continue;
                }
                q.add(new int[]{nx,ny});
                count++;
                visited[nx][ny] = true;
            }
        }
        if(c == 'W'){
            W += (count * count);
            count = 1;
        }
        else{
            B += (count * count);
            count = 1;
        }
    }

}
