package undone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18430_무기공학 {
    static int N,M,ans;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
    }

    private static void dfs(int depth, int sum) {
        if(depth == N*M){
            ans = Math.max(ans,sum);
            return;
        }

        int x = depth/M;
        int y = depth%M;

        if(!visited[x][y]){

        }
    }

}
