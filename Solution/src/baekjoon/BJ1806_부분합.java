package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1806_부분합 {
    static int N;
    static long M;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt= 0;
        int rt = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while(rt<=N) {
           if(sum < M){
               sum += arr[rt++];
           }
           else if(sum > M){
               min = Math.min(min,rt-lt);
               sum -= arr[lt++];
           }
           if(sum==M){
               min = Math.min(min,rt-lt);
               sum += arr[rt++];
           }
        }
        System.out.println(min==Integer.MAX_VALUE ? 0 : min);
    }
}

