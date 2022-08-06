import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15655_N과M8 {
    static int n,m;
    static int[] arr;
    static int[] temp;
    static StringBuilder sb;
    static boolean[] ch;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        st = new StringTokenizer(br.readLine());
        temp = new int[n];
        ch = new boolean[n];

        for(int i=0; i<n; i++){
            temp[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(temp);
        dfs(0,0);
        System.out.print(sb.toString());
    }

    private static void dfs(int cnt,int start) {
        if(cnt == m){
            for(int i=0; i<m; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<n; i++){
            arr[cnt] = temp[i];
            dfs(cnt+1,i);
        }
    }
}
