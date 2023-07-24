package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ4386_별자리만들기 {
    static class Star{
        int num;
        double x;
        double y;
        public Star(int num,double x, double y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    static class Edge {
        int x;
        int y;
        double val;
        public Edge(int x, int y, double val){
            this.x =x;
            this.y= y;
            this.val=val;
        }
    }

    static ArrayList<Star> list;
    static ArrayList<Edge> eList;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new boolean[n];
        eList = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            Star s = new Star(i,x,y);
            list.add(s);
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                Star a = list.get(i);
                Star b = list.get(j);
                double dis = Math.sqrt(Math.pow(Math.abs(a.x-b.x),2)+Math.pow(Math.abs(a.y-b.y),2));
                eList.add(new Edge(a.num,b.num,dis));
            }
        }

        Collections.sort(eList,(o1,o2)->{
            if(o1.val > o2.val){
                return 1;
            }else{
                return -1;
            }
        });

        init(n);

        int count = 0;
        double ans = 0;
        for(Edge e : eList){
            if(count == n-1) break;
            int a = e.x;
            int b = e.y;
            if(union(a,b)){
                count++;
                ans += e.val;
            }
        }
        System.out.printf("%.2f",ans);
        for(int i=0; i<n; i++){
            System.out.print(parent[i]+" ");
        }
    }

    private static void init(int n) {
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }
    private static boolean union(int x ,int y){
        int fx = find(x);
        int fy = find(y);

        if(fx != fy){
            if(fx > fy){
                parent[fx] = fy;
            }else{
                parent[fy] = fx;
            }
            return true;
        }
        return false;
    }

    private static int find(int x) {
        if(parent[x] == x)return x;
        else return parent[x] = find(parent[x]);
    }
}
