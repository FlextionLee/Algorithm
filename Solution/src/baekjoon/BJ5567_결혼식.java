package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5567_결혼식 {
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        int m = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        System.out.println(bfs(n)-1);
    }

    private static int bfs(int n) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        q.add(new int[]{1,0});
        visited[1] = true;
        int count = 0;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[1] == 3) return count;
            count++;
            for(int i : list[tmp[0]]){
                if(visited[i]) continue;
                q.add(new int[]{i,tmp[1]+1});
                visited[i] = true;
            }
        }
        return count;
    }
}
