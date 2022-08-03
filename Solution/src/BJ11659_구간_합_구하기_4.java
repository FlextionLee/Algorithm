import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11659_구간_합_구하기_4 {
    public static StringTokenizer st;
    public static int n,m;
    //public static int[] arr;
    public static int[] sum;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //arr = new int[n];
        sum = new int[n+1];
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            System.out.println(sum[to]-sum[from-1]);
        }

    }
}
