import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW2001_파리퇴치 {
    public static int n,m;
    static int[][] sum;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int TC = 1; TC <= T; TC++) {
            sb.append("#" + TC + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            sum = new int[n+1][n+1];

            for(int i=1; i<=n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=n; j++){
                    sum[i][j] = Integer.parseInt(st.nextToken())  +sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] ;
                }
            }


            int max  = Integer.MIN_VALUE;
            for(int i=m; i<=n; i++){
                for(int j=m; j<=n; j++){
                   max = Math.max(max, sum[i][j] - sum[i][j-m] - sum[i-m][j] + sum[i-m][j-m] );
                }
            }
            System.out.println(max);
        }

    }

}
