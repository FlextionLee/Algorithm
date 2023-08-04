package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ6497_전력난 {
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
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean ing = true;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m ==0){
                break;
            }
            long sum = 0;
            list = new ArrayList<>();
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                sum += val;
                list.add(new Edge(start,end,val));
            }
            Collections.sort(list,(o1,o2)->{
                return o1.val - o2.val;
            });
            init(n);
            long ans = 0;
            int count = 0;
            for(Edge e : list){
                if(count == n-1) break;
                if(union(e.start,e.end)){
                    ans += e.val;
                    count++;
                }
            }
            System.out.println(sum-ans);
        }
    }

    private static boolean union(int start, int end) {
        int fx = find(start);
        int fy = find(end);

        if(fx!=fy){
            if(fx>fy){
                parent[fx] = fy;
            }else{
                parent[fy] = fx;
            }
            return true;
        }
        return false;
    }

    private static int find(int start) {
        if(start == parent[start])return start;
        else return parent[start] = find(parent[start]);
    }

    private static void init(int n) {
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }
}
