package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1516_게임개발 {
    static ArrayList<Integer>[] list;
    static int[] time;
    static int[] indegree;
    static int[] ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        time = new int[n+1];
        indegree = new int[n+1];
        ans = new int[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(true){
                int a = Integer.parseInt(st.nextToken());
                if(a == -1) break;
                indegree[i]++;
                list[a].add(i);
            }
        }
//        for(int i=1; i<=n; i++){
//            ans[i] = time[i];
//        }

        topology(n);

        for(int i=1; i<=n; i++){
            System.out.println(ans[i]+time[i]);
        }
    }

    private static void topology(int n) {
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(new int[]{i,time[i]});
            }
        }

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            for(int i : list[tmp[0]]){
                indegree[i]--;
                ans[i] = Math.max(ans[i], ans[tmp[0]] + time[tmp[0]]);
                if(indegree[i] == 0){
                    q.add(new int[]{i,ans[i]});
                }
            }
        }
    }

}
