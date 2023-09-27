package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1504_특정한최단경로 {
    static class Edge{
        int node;
        int val;
        public Edge(int node, int val){
            this.node = node;
            this.val = val;
        }
    }
    static ArrayList<Edge>[] list;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        N = n;
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<Edge>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b,c));
            list[b].add(new Edge(a,c));
        }
        st = new StringTokenizer(br.readLine());
        int mid1 = Integer.parseInt(st.nextToken());
        int mid2 = Integer.parseInt(st.nextToken());

        int[] startOne = dijkstra(1);
        int[] startMid1 = dijkstra(mid1);
        int[] startMid2 = dijkstra(mid2);

        long sum = (long)startOne[mid1] + (long)startMid1[mid2] + (long)startMid2[n];
        long sum2 = (long)startOne[mid2] + (long)startMid2[mid1] + (long)startMid1[n];

        long ans = Math.min(sum,sum2);

        if(ans >= Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }
    public static int[] dijkstra(int start){
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->{
            return o1.val - o2.val;
        });
        pq.add(new Edge(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            for(Edge e : list[cur.node]){
                if(dist[e.node] > e.val + dist[cur.node]){
                    dist[e.node] = dist[cur.node] + e.val;
                    pq.add(new Edge(e.node,dist[e.node]));
                }
            }
        }
        return dist;
    }
}
