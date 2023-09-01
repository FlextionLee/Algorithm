package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14719_빗물 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int min = arr[0];
        int ans = 0;
        int sum = 0;
        int last = 0;
        for(int i=1; i<m; i++){
            if(min > arr[i]){
                sum += min - arr[i];
            }else{
                ans += sum;
                sum = 0;
                min = arr[i];
                last = i;
            }
        }

        min = arr[m-1];
        sum = 0;
        for(int i=m-1; i>=last; i--){
            if(min > arr[i]){
                sum += min - arr[i];
            }else{
                ans += sum;
                sum = 0;
                min = arr[i];
            }
        }
        System.out.println(ans);

    }
}
