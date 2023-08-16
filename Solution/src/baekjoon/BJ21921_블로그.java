package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ21921_블로그 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i=0; i<m; i++){
            sum += arr[i];
        }
        int max = sum;
        int count = 1;

        for(int i=m; i<n; i++){
            sum -= arr[i-m];
            sum += arr[i];
            if(max < sum){
                max = sum;
                count = 1;
            }else if(max == sum){
                count++;
            }
        }

        if(max == 0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(count);
        }
    }
}
