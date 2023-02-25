package baekjoon;

import java.util.*;
import java.io.*;
public class BJ17144_미세먼지_안녕 {
    static int  R,C,T;
    static int map[][];
    static int[] dx ={0,0,-1,1};
    static int[] dy ={1,-1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for(int i=0; i<R; i++){
             st = new StringTokenizer(br.readLine());
            for(int j=0;j <C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}
