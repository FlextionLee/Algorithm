package baekjoon;

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

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = Integer.MIN_VALUE;
        visited = new boolean[N][M];
        dfs(0,0,0);
        System.out.println(ans);
    }

    private static void dfs(int x, int y, int sum) {
        if(y == M){
            y =0;
            x++;
        }
        if(x == N){
            ans = Math.max(ans,sum);
            return;
        }

        if(x+1 < N && y-1 >= 0 && !visited[x+1][y] &&!visited[x][y]&& !visited[x][y-1]){
            visited[x+1][y] = true;
            visited[x][y-1] = true;
            visited[x][y] = true;
            dfs(x,y+1,sum+(map[x][y]*2)+map[x][y-1]+map[x+1][y]);
            visited[x+1][y] = false;
            visited[x][y-1] = false;
            visited[x][y] = false;
        }

        if(x-1 >= 0 && y-1 >= 0 && !visited[x-1][y]&&!visited[x][y] && !visited[x][y-1]){
            visited[x-1][y] = true;
            visited[x][y-1] = true;
            visited[x][y] = true;
            dfs(x,y+1,sum+(map[x][y]*2)+map[x][y-1]+map[x-1][y]);
            visited[x-1][y] = false;
            visited[x][y-1] = false;
            visited[x][y] = false;
        }

        if(x-1 >= 0 && y+1 < M && !visited[x-1][y]&&!visited[x][y] && !visited[x][y+1]){
            visited[x-1][y] = true;
            visited[x][y+1] = true;
            visited[x][y] = true;
            dfs(x,y+1,sum+(map[x][y]*2)+map[x][y+1]+map[x-1][y]);
            visited[x-1][y] = false;
            visited[x][y+1] = false;
            visited[x][y] = false;
        }

        if(x+1 < N && y+1 < M && !visited[x+1][y]&&!visited[x][y] && !visited[x][y+1]){
            visited[x+1][y] = true;
            visited[x][y+1] = true;
            visited[x][y] = true;
            dfs(x,y+1,sum+(map[x][y]*2)+map[x][y+1]+map[x+1][y]);
            visited[x+1][y] = false;
            visited[x][y+1] = false;
            visited[x][y] = false;
        }

        dfs(x,y+1,sum);
    }
}
