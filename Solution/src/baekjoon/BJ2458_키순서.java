package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2458_키순서 {
    static ArrayList<Integer>[] list;
    static int[][] info;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        int[] win = new int[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            win[b]++;
        }
        info = new int[n+1][2];
        bfs(n);
    }

    private static void bfs(int n) {
        for(int i=1; i<=n; i++){
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[n+1];
            visited[i] = true;
            q.add(i);
            while(!q.isEmpty()){
                int val = q.poll();
                for(int win : list[val]){
                    if(visited[win]) continue;
                    visited[win] = true;
                    q.add(win);
                    info[i][0]++;
                    info[win][1]++;
                }
            }
        }
        int count=0;
        for(int i=1; i<=n; i++){
            if(info[i][0] + info[i][1] == n-1){
                count++;
            }
        }
        System.out.println(count);
    }

}
