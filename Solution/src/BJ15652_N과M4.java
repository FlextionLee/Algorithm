import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15652_N과M4 {

    public static int n,m;
    public static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        dfs(0,1);
        System.out.println(sb.toString());
    }

    private static void dfs(int cnt,int start) {
        if(cnt==m){
            for(int i=0; i<m; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<=n; i++){
            arr[cnt] = i;
            dfs(cnt+1,arr[cnt]);
        }
    }
}
