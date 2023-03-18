package B형특강;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA_문자열교집합 {
    static int T,N,M;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            HashMap<String,Integer> hashMap = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                String str = st.nextToken();
                hashMap.put(str,hashMap.getOrDefault(str,0)+1);
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                String str = st.nextToken();
                hashMap.put(str,hashMap.getOrDefault(str,0)+1);
            }
            int count = 0;
            for (Integer value : hashMap.values()) {
                if(value == 2){
                    count++;
                }
            }
            System.out.println("#"+t+" "+count);
        }
    }
}
