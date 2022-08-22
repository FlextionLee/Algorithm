package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1158_요세푸스_문제 {
    static int N,M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int count = 1;
        while(!q.isEmpty()){
            int a = q.poll();

            if(count%M !=0){
                q.add(a);
            }
            else{
                sb.append(a).append(", ");
            }
            count++;
        }
        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb);
    }
}
