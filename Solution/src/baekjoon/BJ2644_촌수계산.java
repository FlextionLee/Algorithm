package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2644_촌수계산 {
    static int N,t1,t2,M;
    static int[][] map ;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        StringTokenizer st= new StringTokenizer(br.readLine());
        t1 = Integer.parseInt(st.nextToken());
        t2 = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
         st = new StringTokenizer(br.readLine());
         int a= Integer.parseInt(st.nextToken());
         int b= Integer.parseInt(st.nextToken());
         map[a][b] = 1;
         map[b][a] = 1;
        }

        System.out.println(bfs(t1,t2));

    }

    private static int bfs(int t1,int t2) {
        boolean[][] visited = new boolean[N+1][N+1];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {t1,0});

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[0] == t2){
                return tmp[1];
            }
            for(int i=1; i<=N; i++){
                if(map[tmp[0]][i] != 1 || visited[tmp[0]][i]){
                    continue;
                }
                q.add(new int[]{i,tmp[1]+1});
                visited[tmp[0]][i] = true;
            }
        }
        return -1;
    }
}
