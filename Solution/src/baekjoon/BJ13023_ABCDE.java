package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ13023_ABCDE {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] dp;
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        visited = new boolean[n];
        dp = new int[n];
        boolean ch = false;
        for(int i=0; i<n; i++){
            visited = new boolean[n];
            visited[i] = true;
            dfs(i,1);
            if(ans == 5){
                ch = true;
                System.out.println(1);
                break;
            }
        }
        if(!ch){
            System.out.println(0);
        }
    }

    private static void dfs(int dep, int count) {
        if(count == 5){
            ans = 5;
            return;
        }

        for(int i : list[dep]){
            if(!visited[i]){
                visited[i] = true;
                dfs(i,count+1);
                visited[i] = false;
            }
        }
    }
}
