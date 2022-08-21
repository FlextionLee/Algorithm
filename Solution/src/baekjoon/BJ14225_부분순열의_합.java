package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14225_부분순열의_합 {
    static int N,M,sum;
    static int arr[];
    static boolean visited[];
    static boolean check[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        check = new boolean[sum+1];

        subSet(0);
        for(int i=1; i<sum+1; i++){
            if(!check[i]){
                System.out.println(i);
                return;
            }
        }
        System.out.println(sum+1);
    }

    private static void subSet(int depth) {
        if(depth == N){
            int sum = 0;
            for(int i=0; i<N; i++){
                if(visited[i]){
                    sum += arr[i];
                }
            }
            check[sum] = true;
            return;
        }
        visited[depth] = true;
        subSet(depth+1);
        visited[depth] = false;
        subSet(depth+1);
    }




}
