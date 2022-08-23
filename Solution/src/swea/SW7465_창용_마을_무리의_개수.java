package swea;

import java.util.*;
import java.io.*;

public class SW7465_창용_마을_무리의_개수 {
    static int T,N,M;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int count = 0;

            map = new int[N+1][N+1];
            visited = new boolean[N+1];

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[a][b] = 1;
                map[b][a] = 1;
            }

            for(int i=1; i<=N; i++) {
                if(!visited[i]){
                    bfs(i);
                    count++;
                }
            }
            System.out.println("#"+t+" "+count);
        }
    }

    private static void bfs(int i) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        visited[i] = true;

        while(!q.isEmpty()){
            int tmp = q.poll();

            for(int j=1; j<=N ;j++){
                if(visited[j])continue;

                if(map[tmp][j] == 1){
                    q.add(j);
                    visited[j] = true;
                }
            }
        }

    }
}
