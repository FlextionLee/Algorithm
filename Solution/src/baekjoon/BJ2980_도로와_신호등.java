package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2980_도로와_신호등 {
    static int N,L,D,R,G;
    static int[] road;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int wait = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());

            int time = wait + D;
            time %= (R+G);
            if(time <= R){
                wait += R-time;
            }
        }
        System.out.println(L+wait);
    }
}
