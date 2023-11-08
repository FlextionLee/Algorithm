package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lca = new int[n];
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        lca[0] = arr[0];
        int len = 1;

        for(int i=1; i<n; i++){
            int val = arr[i];

            if(lca[len-1] < val){
                lca[len++] = val;
            }else{
                int lt = 0;
                int rt = len-1;
                while(lt<=rt){
                    int mid = (lt+rt)/2;

                    if(lca[mid] >= val){
                        rt = mid-1;
                    }else{
                        lt = mid+1;
                    }
                }
                lca[lt] = val;
            }
        }
        System.out.println(len);
    }
}
