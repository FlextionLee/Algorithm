package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ12738_가장긴증가하는부분수열3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] lis = new int[n];
        lis[0] = arr[0];
        int len = 1;
        for(int i=1; i<n; i++) {
            int key = arr[i];
            if(lis[len-1] < key){
                lis[len] = key;
                len++;
            }else{
                int lo = 0;
                int hi = len-1;

                while(lo < hi){
                    int mid = (lo+hi)/2;
                    if(lis[mid] < key){
                        lo = mid + 1;
                    }else{
                        hi = mid;
                    }
                    //System.out.println(lo+" "+hi);
                }
                lis[lo] = key;
            }
        }
        System.out.println(len);
    }
}
