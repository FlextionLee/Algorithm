package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ11725_트리의부모찾기 {
    static int[] ans;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        visited = new boolean[n+1];
        ans = new int[n+1];
        dfs(1,n+2);
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<n+1; i++){
            sb.append(ans[i]+"\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int depth,int n) {
        for(int i : list[depth]){
            if(!visited[i]){
                ans[i] = depth;
                visited[i] = true;
                dfs(i,n);
            }
        }

    }
}
