package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10816_숫자카드 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            int lt =0;
            int rt = n-1;

            int target = Integer.parseInt(st.nextToken());
            int low = lowbound(target,lt,rt,arr);
            int up = upbound(target,lt,rt,arr);
            sb.append((up-low+1)+" ");
        }
        System.out.println(sb);
    }
    public static int lowbound(int target, int lt, int rt,int[] arr){
        while(lt <= rt){
            int mid = (lt+rt)/2;

            if(arr[mid] < target){
                lt = mid+1;
            }else {
                rt = mid - 1;
            }
        }
        return lt;
    }
    public static int upbound(int target, int lt, int rt, int[] arr){
        while(lt <= rt){
            int mid = (lt+rt)/2;

            if(arr[mid] <= target){
                lt = mid+1;
            }else {
                rt = mid - 1;
            }
        }
        return rt;
    }
}
