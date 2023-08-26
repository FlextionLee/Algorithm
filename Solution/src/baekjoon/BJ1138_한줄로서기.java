package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1138_한줄로서기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        ArrayList<Integer> result = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N; i>=1; i--){
            result.add(arr[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for(int su : result){
            sb.append(su).append(" ");
        }
        System.out.println(sb);
    }
}
