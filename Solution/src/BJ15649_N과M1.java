import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15649_N과M1 {
    static int n,m;
    static int[] current;
    static boolean[] tem;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        current = new int[m];
        tem = new boolean[n+1];
        dfs(0);

    }
    private static void dfs(int cnt) {
        if(cnt == m){
            for(int i=0; i<m; i++) {
                System.out.print(current[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=n; i++){
            if(tem[i]){
                continue;
            }
            current[cnt] = i;
            tem[i] = true;
            dfs(cnt+1);
            tem[i] = false;
        }
    }
}
