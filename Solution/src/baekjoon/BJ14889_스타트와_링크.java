package baekjoon;

import java.util.*;
import java.io.*;
public class BJ14889_스타트와_링크 {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /*
            0 1 2 3 4
            1   1 2 3
            2 4   5 6
            3 7 1   2
            4 3 4 5

         */

        comb(0,1);
        System.out.println(min);
    }

    private static void comb(int depth, int start) {
        if(depth == N/2){
            //complete
           check();
            return;
        }

        for(int i=start; i<=N; i++){
            visited[i] = true;
            comb(depth+1,i+1);
            visited[i] = false;
        }
    }

    private static void check() {
        int arrA[] = new int[N/2];
        int arrB[] = new int[N/2];
        int ai =0;
        int bi =0;

        for(int i=1; i<=N; i++){
            if(visited[i]) arrA[ai++]=i;
            else{
                arrB[bi++]=i;
            }
        }

        int suma = 0;
        int sumb = 0;
        for(int i=0 ;i<N/2; i++){
           for(int j=0; j<N/2; j++){
               suma += map[arrA[i]][arrA[j]];
               sumb += map[arrB[i]][arrB[j]];
           }
        }
        min = Math.min(min, (Math.abs(suma-sumb)));
    }
}
