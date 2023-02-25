package swea;

import sun.reflect.annotation.ExceptionProxy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW14510_나무높이 {
    static int T,N,max;
    static int map[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            N =Integer.parseInt(br.readLine());
            map = new int[N];
            max = 0;
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                map[i] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i], max);
            }

            int sum = 0;
            for(int i=0; i<N; i++){
                map[i] = max - map[i];
                sum += map[i];
            }

            int ans = sum /3 * 2;
            int na  = sum % 3;

            System.out.println(na);

            ans += na;

            System.out.println("#"+t+" "+ans);
        }
    }
}
