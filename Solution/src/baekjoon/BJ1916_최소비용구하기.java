package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1916_최소비용구하기 {
    static class Edge{
        int node, val;
        public Edge(int node, int val){
            this.node = node;
            this.val = val;
        }
    }
    static ArrayList<Edge>[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            list[from].add(new Edge(to,val));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dijkstra(dist,start,end);
    }

    private static void dijkstra(int[] dist,int start, int end) {
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->{
            return o1.val - o2.val;
        });
        pq.add(new Edge(start,0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(cur.node == end){
                System.out.println(dist[end]);
                return;
            }

            for(Edge next : list[cur.node]){
                if(dist[next.node] > cur.val + next.val){
                    dist[next.node] = cur.val + next.val;
                    pq.add(new Edge(next.node,cur.val + next.val));
                }
            }
        }
    }
}
