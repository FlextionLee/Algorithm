package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ11501_주식 {
    static int map[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T ;t++){
            int n = Integer.parseInt(br.readLine());
            map = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                map[i]=Integer.parseInt(st.nextToken());
            }
            int val = 0;
            long sum  =0;
            for(int i=n-1; i>=0; i--){
                if(val < map[i]){
                    val = map[i];
                }else{
                    sum += (val - map[i]);
                }
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }

}
