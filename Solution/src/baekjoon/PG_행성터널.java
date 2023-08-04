package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class PG_행성터널 {
    static int[] parent;
    static class Planet {
        int num;
        int x;
        int y;
        int z;
        public Planet(int num, int x, int y, int z){
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
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
    static ArrayList<Planet> list;
    static ArrayList<Edge> eList;
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        eList = new ArrayList<>();
        parent = new int[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Planet(i,a,b,c));
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                Planet a = list.get(i);
                Planet b = list.get(j);
                int val = getCost(a,b);
                eList.add(new Edge(a.num,b.num,val));
            }
        }

        Collections.sort(eList,(o1,o2)->{
            return o1.val - o2.val;
        });
        init(n);

        int count = 0;
        int ans = 0;
        for(Edge e : eList){
            if(count == n-1) break;
            if(union(e.start,e.end)){
                ans += e.val;
                count++;
            }
        }
        System.out.println(ans);

    }

    private static void init(int n) {
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }

    private static boolean union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if(fx != fy){
            if(fx<fy){
                parent[fy] = fx;
            }else{
                parent[fx] = fy;
            }
            return true;
        }
        return false;
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    private static int getCost(Planet a, Planet b) {
        int ans = Math.min(Math.abs(a.x-b.x) , Math.abs(a.y-b.y));
        ans = Math.min(ans, Math.abs(a.z-b.z));
        return ans;
    }
}
