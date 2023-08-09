package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ14938_서강그라운드 {
    static class Edge{
        int node,val;
        public Edge(int node, int val){
            this.node = node;
            this.val = val;
        }
    }
    static PriorityQueue<Edge> q;
    static int[] info;
    static ArrayList<Edge>[] list;
    static int[] dist;
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        info = new int[n+1];
        list = new ArrayList[n+1];
        dist = new int[n+1];
        q = new PriorityQueue<>((o1,o2)->{
            return o1.val - o2.val;
        });
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            info[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b,c));
            list[b].add(new Edge(a,c));
        }
        for(int i=1; i<=n; i++){
            init();
            dijkstra(i);
            ans = Math.max(ans, check(m));
        }
        System.out.println(ans);
    }

    private static void dijkstra(int d) {
        dist[d] = 0;
        q.add(new Edge(d,0));

        while(!q.isEmpty()){
            Edge tmp = q.poll();
            for(Edge e : list[tmp.node]){
                if(dist[tmp.node]+e.val<dist[e.node]){
                    dist[e.node] = dist[tmp.node]+e.val;
                    q.add(new Edge(e.node,dist[e.node]));
                }
            }
        }
    }

    private static int check(int m) {
        int sum = 0;
        for(int i=1; i<dist.length; i++){
            if(dist[i] <= m) sum += info[i];
        }
        return sum;
    }

    private static void init() {
        Arrays.fill(dist,Integer.MAX_VALUE/1000);
        q.clear();
    }
}
