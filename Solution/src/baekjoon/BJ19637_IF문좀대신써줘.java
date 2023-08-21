package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ19637_IF문좀대신써줘 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] key = new String[n];
        int[] val = new int[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            key[i] = st.nextToken();
            val[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            int num = Integer.parseInt(br.readLine());
            int lt = 0;
            int rt = n-1;
            String ans = "";
            while(lt<=rt){
                int mid = (lt+rt)/2;
                if(val[mid] >= num){
                    ans = key[mid];
                    rt = mid-1;
                }else{
                    lt = mid+1;
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
