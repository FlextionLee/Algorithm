package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ3584_가장가까운공통조상 {
    static ArrayList<Integer>[] list;
    static HashSet<Integer> set;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            list = new ArrayList[n+1];
            for(int i=1; i<=n; i++) {
                list[i] = new ArrayList<>();
            }
            for(int i=0; i<n-1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[b].add(a);
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            set = new HashSet<>();
            dfs1(a);
            dfs2(b);
        }
    }

    private static void dfs2(int b) {
        if(set.contains(b)){
            System.out.println(b);
            return;
        }
        for(int i : list[b]){
            dfs2(i);
        }
    }

    private static void dfs1(int a) {
        set.add(a);
        for(int i : list[a]){
            dfs1(i);
        }
    }
}
