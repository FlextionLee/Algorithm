package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17266_어두운굴다리 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lt = 0;
        int rt = n;
        int ans = 0;
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(isPossible(mid,arr,n)){
                rt = mid-1;
                ans = mid;
            }else{
                lt = mid+1;
            }
        }
        System.out.println(ans);
    }

    private static boolean isPossible(int mid,int[] arr, int n) {
        int prev = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]-mid <= prev){
                prev = arr[i]+mid;
            }
            else{
                return false;
            }
        }
        return n-prev <= 0;
    }
}
