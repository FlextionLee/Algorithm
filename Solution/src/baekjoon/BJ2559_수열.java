package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BJ2559_수열 {
    static int N,M;
    static int[] arr;
    static int[] tmp;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i<M){
                sum +=arr[i];
            }
        }
        int max= sum;
//        int lt=0;
//        int rt=M;
//        while(rt<N){
//            sum = sum - arr[lt++] + arr[rt++];
//            max = Math.max(sum,max);
//        }
        int lt =0;
        for(int rt=M; rt<N; rt++){
            sum += arr[rt];
            sum -= arr[lt++];
            max = Math.max(max,sum);
        }
        System.out.println(max);
    }
}
