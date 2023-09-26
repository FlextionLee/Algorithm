package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1389_케빈베이컨의6단계법칙 {
    static int[][] info;
    static int[][] ans;
    static int num = Integer.MAX_VALUE;
    static int numi;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        N = n;
        info = new int[n+1][n+1];
        ans = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            info[a][b] = 1;
            info[b][a] = 1;
        }

        for(int i=1; i<=n; i++){
            int tmp = bfs(i);
            if(num > tmp){
                num = tmp;
                numi = i;
            }
        }
        System.out.println(numi);
    }

    private static int bfs(int cur) {
        visited = new boolean[N+1];
        visited[cur] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{cur,0});
        int sum = 0;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int i=1; i<=N; i++){
                if(info[tmp[0]][i] == 1 && !visited[i]){
                    visited[i] = true;
                    sum += tmp[1]+1;
                    q.add(new int[]{i,tmp[1]+1});
                }
            }
        }
        return sum;
    }
}
