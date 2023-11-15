package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12015_가장긴증가하는수열2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lt = 0;
        int prev = -1;
        int count = 0;
        for(int rt=0; rt<n; rt++){
            if(arr[rt] > prev){
                count++;
                prev = arr[rt];
            }
        }
        System.out.println(count);
    }
}
