package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2003_수들의_합2 {
    static int N,M;
    static int[] arr;
    static int[] tmp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lt = 0;
        int sum =0;
        int count = 0;

        for(int rt = 0; rt<N; rt++){
            sum+=arr[rt];
            if(sum==M){
                count++;
            }
            if(sum>M){
                while(sum>=M){
                    sum -= arr[lt];
                    lt++;
                    if(sum==M){
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
