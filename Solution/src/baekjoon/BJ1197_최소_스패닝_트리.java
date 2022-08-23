package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1197_최소_스패닝_트리 {
    static int V,E;
    static int[] parents;
    static Edge[] edges;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edges = new Edge[E];
        parents = new int[V+1];
        int sum = 0;

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(x,y,weight);
        }
        //크루스칼 시작
        //간선 정렬
        Arrays.sort(edges, (e1,e2)-> e1.weight-e2.weight);
        makeSet();

        //간선의 수
        int cnt = 0;
        for(int i=0; i<E; i++){
            Edge edge = edges[i];

            if(union(edge.x,edge.y)){
                cnt++;
                sum+=edge.weight;
            }
            if(cnt == V-1)break;
        }
        System.out.println(sum);
    }

   static void makeSet(){
        for(int i=1; i<V; i++){
            parents[i] = i;
        }
    }

    static int findSet(int x){
        if(parents[x] == x){
            return x;
        }
        return parents[x] = findSet(parents[x]);
    }

    static boolean union(int x, int y){
        int px = findSet(x);
        int py = findSet(y);

        if(px == py) return false;

        if(px < py){
            parents[py] = px;
        }
        else{
            parents[px] = py;
        }
        return true;
    }

    static class Edge{
        int x,y,weight;
        public Edge(int x,int y ,int weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}
