package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class SW3234_준환이의_양팔저울 {
    static int T,N,count;
    static boolean visited[];
    static  int[] choo;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sum = 0;
            choo = new int[N];
            visited = new boolean[N];
            for(int i=0; i<N; i++){
                choo[i] = Integer.parseInt(st.nextToken());
                sum += choo[i];
            }

            perm(0,0,0,sum);
            System.out.println(count);
        }
    }

    private static void perm(int depth,int leftSum, int rightSum,int sum) {
        if(depth == N){
            //기저 조건
            count++;
           return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]) continue;

            visited[i] = true;
            perm(depth+1 ,leftSum+choo[i],rightSum,sum-choo[i]);

            if(rightSum+choo[i] <= leftSum){
                perm(depth+1, leftSum,rightSum+choo[i],sum-choo[i]);
            }
            visited[i] =false;
        }
    }
}