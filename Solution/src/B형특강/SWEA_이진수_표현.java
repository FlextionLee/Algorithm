package B형특강;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_이진수_표현 {
    static int T,N,M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int lastNBit = (1<<N) -1;
            if(lastNBit == (M & lastNBit)){
                System.out.println("#"+t+" "+"ON");
            }else {
                System.out.println("#"+t+" "+"OFF");
            }
        }
    }
}
