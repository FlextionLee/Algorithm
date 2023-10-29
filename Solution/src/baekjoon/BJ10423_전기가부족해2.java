package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ10423_전기가부족해2 {
    static int[] parent;
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
    static ArrayList<Edge> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        parent= new int[n+1];
        list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            int a = Integer.parseInt(st.nextToken());
            parent[a] = -1;
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Edge(a,b,c));
        }

        Collections.sort(list,(o1,o2)->{
            return o1.val - o2.val;
        });
        int val = 0;
        for(Edge e : list){
            int a = e.start;
            int b = e.end;
            if(union(a,b)){
                val += e.val;
            }
        }
        System.out.println(val);

    }

    private static boolean union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if(fa != fb){
            if(fa > fb){
                parent[fa] = fb;
            }else{
                parent[fb] = fa;
            }
            return true;
        }
        return false;
    }

    private static int find(int a) {
        if(a==-1){
            return -1;
        }
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

}
