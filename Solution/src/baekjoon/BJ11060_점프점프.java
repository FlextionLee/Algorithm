package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11060_점프점프 {
    static int[] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(bfs(n));
    }
    public static int bfs(int n){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        boolean[] visited = new boolean[n];
        visited[0] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[0] == n-1){
                return tmp[1];
            }

            int count = map[tmp[0]];
            for(int i=1; i<=count; i++){
                if(tmp[0]+i < n && !visited[tmp[0] + i]){
                    q.add(new int[]{tmp[0]+i,tmp[1]+1});
                    visited[tmp[0]+i] = true;
                }
            }
        }
        return -1;
    }

}
