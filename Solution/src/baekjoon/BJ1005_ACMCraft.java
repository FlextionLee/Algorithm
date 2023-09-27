package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1005_ACMCraft {
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] time = new int[n+1];
            int[] indegree = new int[n+1];
            list = new ArrayList[n+1];

            for(int i=1; i<n+1; i++){
                list[i] = new ArrayList<Integer>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<n+1; i++){
                int a = Integer.parseInt(st.nextToken());
                time[i] = a;
            }

            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                indegree[b]++;
            }
            int fin = Integer.parseInt(br.readLine());

            System.out.println(topology(time,indegree,fin));
        }
    }

    private static int topology(int[] time, int[] indegree, int fin) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] result = new int[indegree.length];
        for(int i=1; i<indegree.length; i++){
            if(indegree[i] == 0){
                result[i] = time[i];
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int prev = q.poll();

            for(int i : list[prev]){
                result[i] = Math.max(result[i],result[prev] + time[i]);
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        return result[fin];
    }
}
