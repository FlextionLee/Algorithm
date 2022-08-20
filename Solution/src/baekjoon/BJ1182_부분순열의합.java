package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1182_부분순열의합 {
    static int N,M,count;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0 ;i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);
        if(M==0){
            System.out.println(count-1);
        }
        else{
            System.out.println(count);
        }
    }
    static void dfs(int depth){
        if(depth == N){
            int sum =0;
           for(int i=0; i<N; i++){
               if(visited[i]){
                   sum += arr[i];
               }
               if(sum > M){
                   return;
               }
           }
           if(sum==M) {
               count++;
           }
            return;
        }

        visited[depth] = true;
        dfs(depth+1);
        visited[depth] = false;
        dfs(depth+1);
    }
}
