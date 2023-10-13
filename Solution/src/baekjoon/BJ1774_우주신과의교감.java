package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ1774_우주신과의교감 {
    static class Edge{
        int start;
        int end;
        double val;
        public Edge(int start, int end, double val){
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }
    static int[] parent;
    static int[][] info;
    static ArrayList<Edge> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        info = new int[n+1][2];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            info[i][0] = a;
            info[i][1] = b;
        }
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            for(int j=i+1; j<=n; j++){
                double val = Math.sqrt(Math.pow(Math.abs(info[i][0] - info[j][0]),2) +
                    Math.pow(Math.abs(info[i][1]-info[j][1]),2));
                list.add(new Edge(i,j,val));
            }
        }
        Collections.sort(list,(o1,o2)->{
            return Double.compare(o1.val,o2.val);
        });
        double ans = 0;
        for(Edge e : list){
            if(union(e.start,e.end)){
                ans += e.val;
            }
        }
        System.out.printf("%.2f",ans);
    }

    private static boolean union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if(fa!=fb){
            if(fa < fb){
                parent[fb] = fa;
            }else{
                parent[fa] = fb;
            }
            return true;
        }
        return false;
    }

    private static int find(int a) {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
}
