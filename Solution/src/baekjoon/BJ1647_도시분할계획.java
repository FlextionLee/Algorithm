package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ1647_도시분할계획 {
    static class Edge{
        int start;
        int end;
        int val;
        public Edge(int start, int end, int val){
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }
    static int[] parent;
    static ArrayList<Edge> list;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.add(new Edge(start, end, weight));
        }

        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        Collections.sort(list,(o1,o2)->{
            return o1.val - o2.val;
        });

        int ans = 0;
        int big = 0;
        int count = 0;
        for(Edge e : list){
            if(count == n) break;
            if(union(e.start,e.end)){
                ans += e.val;
                big = Math.max(big,e.val);
                count++;
            }
        }
        System.out.println(ans-big);

    }

    private static boolean union(int s, int e) {
        int a = find(s);
        int b = find(e);

        if(a!=b){
            if(a<b){
                parent[b]=a;
            }else{
                parent[a]=b;
            }
            return true;
        }
        return false;
    }

    private static int find(int start) {
        if(parent[start] == start)return start;
        else return parent[start] = find(parent[start]);
    }
}
