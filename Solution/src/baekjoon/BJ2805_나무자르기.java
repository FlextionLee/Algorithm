package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2805_나무자르기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int rt = 0;
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            rt = Math.max(rt,arr[i]);
        }
        int lt = 0;
        int ans = 0;
        while(lt < rt){
            int mid = (lt+rt)/2;
            long sum = 0;
            for(int h : arr){
                if(h - mid > 0) sum += (h-mid);
            }

            if(sum < m){
                rt = mid;
            }else{
                lt = mid + 1;
            }

        }
        System.out.println(lt-1);
    }
}
