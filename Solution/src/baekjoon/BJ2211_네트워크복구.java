package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ2211_네트워크복구 {
    static class Edge{
        int node,val;
        public Edge(int node, int val){
            this.node =node;
            this.val = val;
        }
    }
    static ArrayList<Edge>[] list;
    static int[] dist;
    static Edge[] ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        dist= new int[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<Edge>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b,c));
            list[b].add(new Edge(a,c));
        }
        ans = new Edge[n+1];
        dijkstra(1);
        int count = 0;
        for(int i=1; i<ans.length; i++){
            if(ans[i]!=null){
                count++;
            }
        }
        System.out.println(count);
        for(int i=1; i<ans.length; i++){
            if(ans[i]!=null){
                System.out.println(ans[i].node+" "+ans[i].val);
            }
        }
    }

    private static void dijkstra(int i) {
        Arrays.fill(dist, Integer.MAX_VALUE/100);
        dist[i] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->{
            return o1.val - o2.val;
        });
        pq.add(new Edge(i,0));

        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            for(Edge e : list[tmp.node]){
                if(dist[e.node] > dist[tmp.node] + e.val){
                    dist[e.node] = dist[tmp.node] + e.val;
                    pq.add(new Edge(e.node, dist[e.node]));
                    ans[e.node] = new Edge(tmp.node,e.node);
                }
            }
        }
    }
}
