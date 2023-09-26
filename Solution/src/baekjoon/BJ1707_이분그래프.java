package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1707_이분그래프 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] color;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for(int k=1; k<=K; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            list = new ArrayList[n+1];

            for(int i=1; i<=n; i++){
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }

            visited = new boolean[n+1];
            boolean ch = true;
            for(int i=1; i<=n; i++){
                if(!visited[i]){
                    if(!bfs(i)){
                        System.out.println("NO");
                        ch = false;
                        break;
                    }
                }
            }
            if(ch){
                System.out.println("YES");
            }
        }
    }
    public static boolean bfs(int idx){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{idx,1});
        color = new int[list.length];
        color[idx] = 1;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(Integer i : list[tmp[0]]){
                if(!visited[i]){
                    visited[i] = true;
                    color[i] = 1 - tmp[1];
                    q.add(new int[]{i,color[i]});
                }else{
                    if(color[tmp[0]] == color[i]) return false;
                }
            }
        }
        return true;
    }
}
