package baekjoon;

import java.io.*;
import java.util.*;

public class BJ14888_연산자_끼워넣기 {
    static int N,size;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] numbers;
    static String operators;
    static char[] opers;
    static char[] target;
    static boolean visited[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<4; i++){
            int J = Integer.parseInt(st.nextToken());
            for(int j=1; j<=J; j++){
                if(i==0){
                    sb.append('+');
                }
                else if(i==1){
                    sb.append('-');
                }
                else if(i==2){
                    sb.append('*');
                }
                else{
                    sb.append('/');
                }
            }
        }
        opers = sb.toString().toCharArray();
        size = opers.length;
        target = new char[size];
        visited = new boolean[size];

        perm(1,numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void perm(int depth,int sum) {
        if(depth == N){
            max = Math.max(sum,max);
            min = Math.min(sum,min);
            return;
        }

        for(int i=0; i<size; i++){
            if(visited[i]){
                continue;
            }
            visited[i]= true;
            if(opers[i]=='+'){
                perm(depth+1,sum+numbers[depth]);
            }
            else if(opers[i]=='-'){
                perm(depth+1,sum-numbers[depth]);
            }
            else if(opers[i]=='*'){
                perm(depth+1,sum*numbers[depth]);
            }
            else{
                perm(depth+1,sum/numbers[depth]);
            }
            visited[i] =false;
        }
    }
}
