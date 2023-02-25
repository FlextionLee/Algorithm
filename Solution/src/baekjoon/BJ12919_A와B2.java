package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ12919_A와B2 {
    static StringBuilder T;
    static StringBuilder S;
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = new StringBuilder(br.readLine());
        T = new StringBuilder(br.readLine());

        ans = 0;
        dfs(S);
        System.out.println(0);
    }

    private static void dfs(StringBuilder S) {
        System.out.println(S);
        if(S.length() == T.length()){
            if(S.equals(T)){
                ans = 1;
            }
            return;
        }
        S.append("A");
        dfs(S);
        S.deleteCharAt(S.length()-1);
        S.append("B");
        S.reverse();
        dfs(S);
    }
}
