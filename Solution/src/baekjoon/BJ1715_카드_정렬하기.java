package baekjoon;

import java.util.*;
import java.io.*;
public class BJ1715_카드_정렬하기 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> q = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            q.add(Long.parseLong(st.nextToken()));
        }

        long c =0;
        while( q.size() >=2){
            Long a = q.poll();
            Long b = q.poll();
            c += a+b;
            q.add(a+b);
        }
        System.out.println();
    }
}
