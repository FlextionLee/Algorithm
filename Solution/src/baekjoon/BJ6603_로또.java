package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ6603_로또 {
    static int N;
    static int[] arr;
    static int[] tmp;
    static boolean[] visited;
    static StringBuilder sb= new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if(N==0){
                break;
            }

            tmp = new int[6];
            arr = new int[N];

            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            dfs(0,0);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int depth, int start) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            tmp[depth] = arr[i];
            dfs(depth+ 1,  i+1);
        }
    }
}
