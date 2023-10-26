package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1654_랜선자르기 {
    static int[] lan;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        lan = new int[n];
        long rt = Long.MIN_VALUE;
        for(int i=0; i<n; i++){
            lan[i] = Integer.parseInt(br.readLine());
            rt = Math.max(rt,lan[i]);
        }

        long lt = 1;
        long ans = 0;
        while(lt<=rt){
            long mid = (lt+rt)/2;
            long cut = cut(mid);
            if(cut < m){
                rt = mid-1;
            }else{
                ans = mid;
                lt = mid+1;
            }
        }
        System.out.println(ans);
    }
    public static long cut(long mid){
        long val = 0;
        for(int i=0; i<lan.length; i++){
            val += lan[i]/mid;
        }
        return val;
    }
}
