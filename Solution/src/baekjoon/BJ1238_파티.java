package undone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1238_파티 {
    static int N,M,X;
    static int[][] map;
    static int[][] dist;
    static int[] student;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        dist = new int[N+1][N+1];

        init();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = c;
        }

        dijkstra();
    }

    private static void init() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                dist[i][j] = Integer.MAX_VALUE/1000;
            }
        }
    }

    private static void dijkstra() {
        for(int i=0; i<N; i++) {
            Queue<int[]> q = new ArrayDeque<>();
            init();
            q.add(new int[] {i,0});
            while(!q.isEmpty()){
                int tmp[] = q.poll();

                for(int j=0; j<N; j++){
                   if(map[tmp[0]][j]!=0){

                   }
                }
            }

        }
    }
}
