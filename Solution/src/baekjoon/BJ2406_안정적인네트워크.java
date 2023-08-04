package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ2406_안정적인네트워크 {
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
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        init(n+1);

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            union(start, end);
        }
        //연결정보 등록
        int[][] info = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //간선 등록
        ArrayList<Edge> list = new ArrayList<>();
        for(int i=2; i<=n; i++){
            for(int j=i+1; j<=n; j++){
                list.add(new Edge(i,j,info[i][j]));
            }
        }
        Collections.sort(list,(o1,o2)->{
            return o1.val - o2.val;
        });

        int min = 0;
        int count =0;
        ArrayList<Edge> ansList = new ArrayList<>();

        for(Edge e : list){
            if(union(e.start,e.end)){
                min += e.val;
                count++;
                ansList.add(new Edge(e.start,e.end,0));
            }
        }
        System.out.println(min+" "+count);
        for(Edge e : ansList){
            System.out.println(e.start+" "+e.end);
        }
    }

    private static void init(int n) {
        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i] = i;
        }
    }

    private static boolean union(int start, int end) {
        int fx = find(start);
        int fy = find(end);

        if(fx!=fy){
            if(fx<fy){
                parent[fy] = fx;
            }else{
                parent[fx] = fy;
            }
            return true;
        }
        return false;
    }

    private static int find(int start) {
        if(start == parent[start])return start;
        else return parent[start] = find(parent[start]);
    }
}
