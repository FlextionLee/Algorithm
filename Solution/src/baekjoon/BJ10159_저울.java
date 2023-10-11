package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ10159_저울 {
    static ArrayList<Integer>[] list;
    static int[][] res;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        res = new int[n+1][2];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

        for(int i=1; i<=n; i++){
            bfs(i,n);
        }
        for(int i=1; i<=n; i++){
            System.out.println(n-1-(res[i][0]+res[i][1]));
        }
    }

    private static void bfs(int i, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        visited = new boolean[n+1];
        visited[i] = true;
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int j : list[tmp]){
                if(!visited[j]){
                    q.add(j);
                    res[i][0]++;
                    res[j][1]++;
                    visited[j] = true;
                }
            }
        }
    }
}
