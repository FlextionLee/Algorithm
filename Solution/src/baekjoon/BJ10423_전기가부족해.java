package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ10423_전기가부족해 {
    static class Edge{
        int start,end,val;
        public Edge(int start, int end, int val){
            this.start = start;
            this.end = end;
            this.val =val;
        }
    }
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Edge> list = new ArrayList<>();
        ArrayList<Edge> elecList = new ArrayList<>();
        parent = new int[n+1];
        st = new StringTokenizer(br.readLine());
        init(n);
        for(int i=0; i<k; i++){
            parent[Integer.parseInt(st.nextToken())] =-1;
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            list.add(new Edge(a,b,c));
        }
        Collections.sort(list,(o1,o2)->{
            return o1.val - o2.val;
        });

        int count =0;
        int ans = 0;

        for(Edge e : list){
            if(union(e.start,e.end)){
                ans += e.val;
                count++;
            }
        }

        for(int i=0; i<parent.length; i++){
            System.out.print(parent[i]+" ");
        }
        System.out.println(ans);
    }

    private static boolean union(int start, int end) {
        int fx = find(start);
        int fy = find(end);
        if(fx!=fy){
            if(fx > fy){
                parent[fx] = fy;
            }else{
                parent[fy] = fx;
            }
            return true;
        }
        return false;
    }

    private static int find(int s) {
        if(parent[s] == -1) return -1;
        if(parent[s] == s) return s;
        else return parent[s] = find(parent[s]);
    }

    private static void init(int n) {
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
    }
}
