package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2138_전구와스위치 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cur = new int[n];
        int[] last = new int[n];

        String str= br.readLine();
        for(int i=0; i<n; i++){
            cur[i] = str.charAt(i);
        }

        str= br.readLine();
        for(int i=0; i<n; i++){
            last[i] = str.charAt(i);
        }
    }
}
