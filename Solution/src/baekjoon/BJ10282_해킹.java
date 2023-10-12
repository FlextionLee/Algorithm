package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ10282_해킹 {
    static class Edge{
        int node;
        int val;
        public Edge(int node, int val){
            this.node = node;
            this.val =val;
        }
    }
    static ArrayList<Edge>[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int com = Integer.parseInt(st.nextToken());
            list = new ArrayList[n+1];
            for(int i=1; i<=n; i++){
                list[i] = new ArrayList<>();
            }
            for(int i=0; i<d; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list[b].add(new Edge(a,c));
            }
            dijkstra(com,n);
        }
    }

    private static void dijkstra(int com, int n) {
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[com] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->{
            return o1.val - o2.val;
        });
        pq.add(new Edge(com,0));

        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            for(Edge e : list[tmp.node]){
                if(dist[e.node] > dist[tmp.node]+e.val){
                    dist[e.node] = dist[tmp.node]+e.val;
                    pq.add(new Edge(e.node,dist[e.node]));
                }
            }
        }
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) continue;
            else{
                count++;
                if(max < dist[i]){
                    max = dist[i];
                }
            }
        }
        System.out.println(count+" "+max);
    }
}
