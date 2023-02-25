package swea;

import java.util.*;
import java.io.*;

public class SW4008_숫자_만들기{
    static int T,N,min,max;
    static int num[];
    static int oper[];
    static boolean visited[];
    static int target[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            oper = new int[4];
            num = new int[N];
            visited = new boolean[N-1];
            target = new int[N-1];

            for(int i=0; i<4; i++){
                oper[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }

            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            perm(0);
            System.out.println("#"+t+" "+(max-min));
        }
    }

    private static void perm(int depth) {
        if(depth == N-1){
            //complete
            calc();
            return;
        }

        for(int i=0; i<4; i++){
            if(oper[i] > 0){
                target[depth] = i;
                oper[i]--;
                perm(depth+1);
                oper[i]++;
            }
        }
    }

    private static void calc() {
        int sum = num[0];
        for(int i=0; i<N-1; i++) {
            switch (target[i]) {
                case 0:
                    sum+=num[i+1];
                    break;
                case 1:
                    sum-=num[i+1];
                    break;
                case 2:
                    sum*=num[i+1];
                    break;
                case 3:
                    sum/=num[i+1];
                    break;
            }
        }
        max = Math.max(max,sum);
        min = Math.min(min,sum);
    }
}
