package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ11779_최소비용구하기2_2 {
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
    static int[] info;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        info = new int[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b,c));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dijkstra(start,end);
        Stack<Integer> s = new Stack<>();
        System.out.println(dist[end]);
        int count = 0;
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

    private static void dijkstra(int start,int end) {
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2)->{
            return o1.val - o2.val;
        });
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            System.out.println(e.node);
            if(e.node == end){
                return;
            }

            for(Edge next : list[e.node]){
                if(dist[next.node] > dist[e.node]+next.val){
                    dist[next.node] = dist[e.node]+next.val;
                    pq.add(new Edge(next.node, dist[next.node]));
                    info[next.node] = e.node;
                }
            }
        }
    }
}
