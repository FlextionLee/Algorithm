package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15651_N과M3 {

    static public int n,m;
    static public int[] arr;
    static public StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        sb = new StringBuilder();
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
        for(int i=1; i<=n; i++){
            arr[cnt] = i;
            dfs(cnt+1);
        }
    }
}
