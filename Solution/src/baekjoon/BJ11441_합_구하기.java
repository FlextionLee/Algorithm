package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11441_합_구하기 {
    static int N;
    static int T;
    static int arr[];
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<N; i++){
            arr[i] =arr[i-1]+Integer.parseInt(st.nextToken());
        }
        int len = Integer.parseInt(br.readLine());
        for(int i=0; i<len; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken())-1;
            int tmp;
            if(start == 1){
                tmp = arr[end];
            }
            else{
                tmp = arr[end] - arr[start-2];
            }

            sb.append(tmp).append("\n");
        }
        System.out.println(sb.toString());
    }
}
