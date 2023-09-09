package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ13418_학교탐방하기 {
    static class Edge{
        int start;
        int end;
        int val;
        public Edge(int start, int end, int val){
            this.start = start;
            this.end = end;
            this.val =val;
        }
    }
    static int[] parent;
    static ArrayList<Edge> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i=0; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Edge(a,b,c));
        }
        init();
        Collections.sort(list,(o1,o2)->{
            return o1.val - o2.val;
        });
        int val = 0;
        int count = 0;
        for(Edge e : list){
            if(count == n) break;
            if(union(e)){
                if(e.val == 0) val++;
                count++;
            }
        }
        init();
        Collections.sort(list,(o1,o2)->{
            return o2.val - o1.val;
        });
        int val2 = 0;
        int count2 = 0;
        for(Edge e : list){
            if(count2 == n) break;
            if(union(e)){
                if(e.val == 0) val2++;
                count2++;
            }
        }
        int min = (int)Math.pow(val2,2);
        int max = (int)Math.pow(val,2);
        System.out.println(max-min);
    }

    private static boolean union(Edge e) {
        int fx = find(e.start);
        int fy = find(e.end);
        if(fx==fy){
            return false;
        }else{
            if(fx < fy){
                parent[fy] = fx;
            }else {
                parent[fx] = fy;
            }
        }
        return true;
    }

    private static int find(int start) {
        if(start == parent[start]) return start;
        else return parent[start] = find(parent[start]);
    }

    private static void init() {
        for(int i=1; i<parent.length; i++){
            parent[i] = i;
        }
    }
}
