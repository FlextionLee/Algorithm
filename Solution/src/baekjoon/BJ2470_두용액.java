package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2470_두용액 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int ans = Integer.MAX_VALUE;
        int a1 = 0;
        int a2 = 0;
        int rt = n-1;
        Arrays.sort(arr);
        int sum;
        int tmp;
        while(lt<rt){
            sum = arr[lt] + arr[rt];
            tmp = Math.abs(sum);
            if(tmp < ans) {
                ans = Math.abs(arr[lt] + arr[rt]);
                a1 = arr[lt];
                a2 = arr[rt];
            }
            if(sum > 0){
                rt--;
            }else{
                lt++;
            }
        }
        System.out.println(a1+" "+a2);
    }
}
