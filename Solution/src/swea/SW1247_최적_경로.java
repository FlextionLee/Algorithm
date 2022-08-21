package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SW1247_최적_경로 {
    static int T,N,min;
    static int compX,compY,homeX,homeY;
    static int[][] nodes;
    static int[][] comp;
    static int[][] home;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            nodes = new int[N][N];
            visited = new boolean[N];


            StringTokenizer st = new StringTokenizer(br.readLine());
            compX = Integer.parseInt(st.nextToken());
            compY = Integer.parseInt(st.nextToken());
            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());
            for(int i=0; i<N; i++){
                nodes[i][0]  =  Integer.parseInt(st.nextToken());
                nodes[i][1]  =  Integer.parseInt(st.nextToken());
            }
            perm(0,compX,compY,0);
            System.out.println("#"+t+" "+min);
        }
    }

    private static void perm(int depth,int beforeX,int beforeY,int size) {
        if(depth == N){
            min = Math.min(size+calc(beforeX,beforeY,homeX,homeY),min);
            return;
        }

        if(size > min){
            return;
        }

        for(int i=0; i<N ;i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            perm(depth+1, nodes[i][0],nodes[i][1], size+calc(beforeX,beforeY,nodes[i][0],nodes[i][1]));
            visited[i] =false;
        }
    }

    private static int calc(int ax,int ay,int bx,int by) {
        return Math.abs(ax-bx) + Math.abs(ay-by);
    }
}
