package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ11779_최소비용구하기 {
    static class Edge{
        int node;
        int val;
        public Edge(int node, int val){
            this.node = node;
            this.val = val;
        }
    }
    static ArrayList<Edge>[] list;
    static int[] dist;
    static ArrayList<Integer> ans;
    static int[] info;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<Edge>();
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b,c));
            //list[b].add(new Edge(a,c));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        ans = new ArrayList<>();
        info = new int[n+1];

        dijkstra(start,end);
        System.out.println(dist[end]);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        Stack<Integer> s = new Stack<>();
        while(true){
            s.push(end);
            end = info[end];
            count++;
            if(end == 0){
                break;
            }
        }
        System.out.println(count);
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->{
            return o1.val - o2.val;
        });
        dist[start] = 0;
        pq.add(new Edge(start,0));

        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            if(tmp.node == end){
                return;
            }

            for(Edge e : list[tmp.node]){
                if(dist[e.node] > dist[tmp.node]+e.val){
                    dist[e.node] = dist[tmp.node]+e.val;
                    info[e.node] = tmp.node;
                    pq.add(new Edge(e.node,dist[e.node]));
                }
            }
        }
    }
}
