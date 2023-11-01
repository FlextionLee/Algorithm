package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2343_기타레슨 {
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        long rt = 0;
        long lt = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            rt += arr[i];
            lt = Math.max(lt,arr[i]);
        }

        long ans = 0;
        while(lt<=rt) {
            long mid = (lt + rt) / 2;

            long val = get(mid);
            if (val > m) {
                lt = mid + 1;
            }else {
                rt = mid - 1;
            }
        }
        System.out.println(lt);

    }
    public static long get(long mid){
        int count = 0;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            if(sum + arr[i] <= mid){
                sum += arr[i];
            }else{
                count++;
                sum = arr[i];
            }
        }
        if(sum != 0) count++;
        return count;
    }
}
