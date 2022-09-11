package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ8370_Plane {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] tmp = new int[4];
        for(int i=0; i<4; i++){
            tmp[i]  = Integer.parseInt(st.nextToken());
        }

        System.out.println((tmp[0]*tmp[1]) +(tmp[2]*tmp[3]) );
    }
}
