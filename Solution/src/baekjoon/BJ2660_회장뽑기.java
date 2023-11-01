package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2660_회장뽑기 {
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==-1 && b==-1) break;
            list[a].add(b);
            list[b].add(a);
        }
        int[] info = new int[n+1];
        ArrayList<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            info[i] = bfs(i,n);
            if(info[i] < min){
                ans = new ArrayList<>();
                min = info[i];
                ans.add(i);
            }else if(info[i] == min){
                ans.add(i);
            }
        }
        System.out.println(min+" "+ans.size());
        for(int i=0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
    }

    private static int bfs(int i,int n) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,0});
        boolean[] visited = new boolean[n+1];
        visited[i]= true;
        int dep = 0;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            dep = tmp[1];
            for(int j : list[tmp[0]]){
                if(!visited[j]){
                    visited[j] = true;
                    q.add(new int[]{j,tmp[1]+1});
                }
            }
        }

        return dep;
    }
}
