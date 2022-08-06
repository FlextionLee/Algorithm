import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15654_N과M5{
    static int n,m;
    static int[] arr;
    static int[] temp;
    static boolean[] ch;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        st = new StringTokenizer(br.readLine());
        ch = new boolean[n];
        temp = new int[n];

        for(int i=0; i<n; i++){
            temp[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(temp);
        dfs(0);
        System.out.println(sb.toString());
    }

    private static void dfs(int cnt) {
        if(cnt == m){
            for(int i=0; i<m; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<n; i++){
            if(ch[i]){
                continue;
            }
            arr[cnt] = temp[i];
            ch[i] = true;
            dfs(cnt+1);
            ch[i] = false;
        }
    }
}
