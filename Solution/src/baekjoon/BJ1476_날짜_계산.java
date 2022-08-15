package baekjoon;

import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class BJ1476_날짜_계산 {
    static int E,S,M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int i = 0;
        while(true){
            int xE = i%15+1;
            int xS = i%28+1;
            int xM = i%19+1;

            if(xE == E && xS == S && xM == M){
                System.out.println(i+1);
                break;
            }
            i++;
        }
    }
}
