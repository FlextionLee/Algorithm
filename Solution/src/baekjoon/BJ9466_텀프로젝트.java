package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ9466_텀프로젝트 {
    static boolean[] visited,isDone;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int n = Integer.parseInt(br.readLine());
            int[] indegree = new int[n+1];
            int[] info = new int[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                int m = Integer.parseInt(st.nextToken());
                info[i] = m;
                indegree[m]++;
            }

            Queue<Integer> q = new ArrayDeque<>();
            for(int i=1; i<=n; i++){
                if(indegree[i] == 0){
                    q.add(i);
                }
            }

            int ans = 0;
            while(!q.isEmpty()){
                int now = q.poll();
                System.out.println(now+" "+info[now]);
                ans++;
                indegree[info[now]]--;
                if(indegree[info[now]] == 0){
                    q.add(info[now]);
                }
            }

            for(int i=1; i<=n; i++){
                System.out.print(indegree[i]+" ");
            }
            //System.out.println(ans);
        }
    }
}
