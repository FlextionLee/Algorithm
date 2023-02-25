package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3980_선발명단 {
    static int T,ans;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            map = new int[11][11];
            visited = new boolean[11];
            ans = 0;
            for(int i=0; i<11; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<11; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0,0);
            System.out.println(ans);
        }

    }

    private static void dfs(int x, int sum) {
        if(x==11) {
            ans = Math.max(sum, ans);
            return;
        }

        for(int i=0; i<11; i++){
            if(map[x][i]!=0 && !visited[i]){
                visited[i] = true;
                dfs(x+1,sum+map[x][i]);
                visited[i] = false;
            }
        }
    }
}
