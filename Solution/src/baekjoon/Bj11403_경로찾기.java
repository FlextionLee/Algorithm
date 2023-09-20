package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj11403_경로찾기 {
    static int[][] ans;
    static int[][] map;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        N = n;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = new int[n][n];
        for(int i=0; i<n; i++){
            visited = new boolean[n];
            dfs(i,i);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(ans[i][j] +" ");
            }
            System.out.println();
        }
    }
    public static void dfs(int depth,int idx){
        for(int i=0; i<N; i++){
            if(map[depth][i] == 1 && !visited[i]){
                visited[i] = true;
                ans[idx][i] = 1;
                dfs(i,idx);
            }
        }
    }
}
