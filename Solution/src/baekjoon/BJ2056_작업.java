package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2056_작업 {
    static int[] indegree;
    static int[] time;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list= new ArrayList[n+1];
        indegree = new int[n+1];
        time = new int[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;
            int count = Integer.parseInt(st.nextToken());
            for(int j=0; j<count; j++){
                int val = Integer.parseInt(st.nextToken());
                list[val].add(i);
                indegree[i]++;
            }
        }
        System.out.println(topology(n));
    }

    private static int topology(int n ) {
        Queue<int[]> q = new ArrayDeque<>();

        int[] ans = new int[n+1];

        for(int i=1; i<=n; i++){
            if(indegree[i] == 0){
                q.add(new int[]{i,time[i]});
                ans[i] = time[i];
            }
        }

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int i : list[tmp[0]]){
                indegree[i]--;
                ans[i] = Math.max(ans[tmp[0]] + time[i],ans[i]);
                if(indegree[i]==0){
                    q.add(new int[]{i,tmp[1]+time[i]});
                }
            }
        }
        int ret = 0;
        for(int i=1; i<=n; i++){
            ret = Math.max(ans[i],ret);
        }

        return ret;
    }
}
