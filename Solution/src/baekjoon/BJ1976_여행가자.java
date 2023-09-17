package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1976_여행가자 {
    static int[][] map;
    static int[] loot;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine())+1;
        int m = Integer.parseInt(br.readLine());
        map = new int[n][n];
        loot = new int[m];
        visited = new boolean[n];
        N = n;
        for(int i=1; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            loot[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[n];
        visited[loot[0]] = true;
        dfs(loot[0]);
        for(int i=0; i<loot.length; i++){
            if(!visited[loot[i]]){
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }

    private static void dfs(int start) {
        for(int i=1; i<N; i++){
            if(map[start][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
