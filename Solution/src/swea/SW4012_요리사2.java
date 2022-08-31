package swea;

import java.io.*;
import java.util.*;

/**
 * 식재료 N/2 나눈다. 2개의 요리를 함
 * A음식 ,B음식
 *
 * A - B  차이가 최소가 되도록 재료 분배
 * 식재료들은 N/2로 나눠서
 * 그 조합을 불린 배열 트루 - 폴스
 */

public class SW4012_요리사2 {
    static int T,N,M,min;
    static int[][] map;
    static boolean[] target;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N+1][N+1];
            target = new boolean[N+1];
            M = N/2;
            min = Integer.MAX_VALUE;

            for(int i=1; i<=N; i++){
                StringTokenizer st= new StringTokenizer(br.readLine());
                for(int j=1; j<=N;j++){
                    if(i>j){
                        map[j][i] += Integer.parseInt(st.nextToken());
                    }
                    else{
                        map[i][j] += Integer.parseInt(st.nextToken());
                    }
                }
            }
            comb(0,1);
            System.out.println("#"+t+" "+min);
        }

    }

    private static void comb(int depth, int start) {
        if(depth == M){
            //complte
            int arrA[] = new int[M];
            int arrB[] = new int[M];
            int ai = 0;
            int bi = 0;
            int suma=0;
            int sumb=0;

            for(int i=1; i<=N; i++){
                if(target[i]){
                   arrA[ai++] = i;
                }
                else{
                    arrB[bi++] = i;
                }
            }
            for(int i=0; i<M;i++){
                for(int j=i+1; j<M;j++){
                    suma += map[arrA[i]][arrA[j]];
                    sumb += map[arrB[i]][arrB[j]];
                }
            }
            min = Math.min(min,Math.abs(suma-sumb)) ;
        }

        for(int i=start; i<=N; i++){
            target[i] = true;
            comb(depth+1,i+1);
            target[i] = false;
        }
    }
}
