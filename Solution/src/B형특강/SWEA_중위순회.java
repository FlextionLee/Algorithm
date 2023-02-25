package B형특강;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_중위순회 {
    static int N;
    static char[] tree;
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t=1;t<=10;t++){
            N = Integer.parseInt(br.readLine());
            tree = new char[N+1];
            sb = new StringBuilder();
            for(int i=1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                tree[i] = st.nextToken().charAt(0);
            }

            dfs(1);
            System.out.println(sb);
        }
    }

    private static void dfs(int i) {
        if(i>N) return;
        System.out.println(i);
        dfs(i*2);
        sb.append(tree[i]);
        dfs(i*2+1);
    }
}
