package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1005_ACMCraft2 {
    static int[] indegree;
    static int[] time;
    static int[] ans;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            time = new int[n+1];
            list = new ArrayList[n+1];
            ans = new int[n+1];
            indegree = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                time[i] = Integer.parseInt(st.nextToken());
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                indegree[b]++;
            }

            topology();
            int target = Integer.parseInt(br.readLine());
            System.out.println(ans[target]);
        }
    }

    private static void topology() {
        Queue<int[]> q = new ArrayDeque<>();

        for(int i=1; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.add(new int[]{i,time[i]});
                ans[i] = time[i];
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i : list[cur[0]]){
                indegree[i]--;
                ans[i] = Math.max(ans[i], time[i]+cur[1]);
                if(indegree[i] == 0){
                    q.add(new int[]{i,ans[i]});
                }
            }
        }
    }
}
