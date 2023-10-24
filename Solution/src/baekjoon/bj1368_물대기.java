package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bj1368_물대기 {
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
    public static ArrayList<Edge> list;
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cost = new int[n+1];
        list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            cost[i] = Integer.parseInt(br.readLine());
        }
        for(int i=1; i<=n; i++){
            String[] line = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                int w = Integer.parseInt(line[j - 1]);
                if (i == j) {
                    list.add(new Edge(0, i, cost[i]));
                } else if (i < j) {
                    list.add(new Edge(i, j, w));
                }
            }
        }
        Collections.sort(list,(o1, o2)->{
            return o1.val - o2.val;
        });
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i ;
        }

        int c = 0;
        int val = 0;
        for(Edge e : list){
            if(c == list.size()-1) break;
            int start = e.start;
            int end = e.end;
            if(union(start,end)){
                c++;
                val += e.val;
            }
        }
        System.out.println(val);
    }

    private static boolean union(int start, int end) {
        int fa = find(start);
        int fb = find(end);
        if(fa != fb){
            if(fa<fb){
                parent[fb] = fa;
            }else{
                parent[fa] = fb;
            }
            return true;
        }
        return false;
    }

    private static int find(int start) {
        if(parent[start] == start) return start;
        else return parent[start] = find(parent[start]);
    }
}
