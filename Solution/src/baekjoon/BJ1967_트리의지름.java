package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1967_트리의지름 {
    static class Edge{
        int node;
        int val;
        public Edge(int node, int val){
            this.node = node;
            this.val = val;
        }
    }
    static ArrayList<Edge>[] list;
    static int len;
    static int end;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<Edge>();
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b,c));
            list[b].add(new Edge(a,c));
        }
        visited = new boolean[n+1];
        visited[1] = true;
        len = Integer.MIN_VALUE;
        dfs(1,n,0);

        visited = new boolean[n+1];
        visited[end] = true;
        len = Integer.MIN_VALUE;
        dfs(end,n,0);

        System.out.println(len);
    }
    public static void dfs(int depth,int n,int sum){
        if(len < sum){
            end = depth;
            len = sum;
        }
        for(Edge e : list[depth]){
            if(!visited[e.node]){
                visited[e.node] = true;
                dfs(e.node,n,sum+e.val);
            }
        }
    }
}
