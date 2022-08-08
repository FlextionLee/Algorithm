package swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class SW9229_한빈이와_Spot_Mart  {
    static int T,N,M;
    static int[] arr;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int sum = -1;
            for(int i=0; i<N; i++) {
                for(int j=i+1; j<N; j++) {
                    int tmp = arr[i] + arr[j];
                    if(tmp <= M) {
                        if(sum < tmp) {
                            sum = tmp;
                        }
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }
}