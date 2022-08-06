import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15663_N과M9 {

    public static int n,m;
    public static int[] arr;
    public static int[] temp;
    public static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        temp = new int[n];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            temp[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(temp);

        dfs(0);
        System.out.println(sb.toString());
    }

    public static void dfs(int depth) {
        if(depth == m){
            for(int i=0; i<m; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++){
            arr[depth] = temp[i];
            dfs(depth+1);
        }
    }
}
