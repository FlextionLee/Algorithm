package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5014_스타트링크 {
    static int F,S,G,U,D, answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        String ans = "use the stairs";

        dfs(S,0);
        if(answer == Integer.MAX_VALUE){
            System.out.println(ans);
        }
        else{
            System.out.println(answer);
        }
    }

    private static void dfs(int cur, int count) {
        if(cur < 1 || cur > F){
            return;
        }
        if(cur == G){
            answer = Math.min(answer, count);
            return;
        }
        dfs(cur+U, count +1);
        dfs(cur-D, count +1);
    }
}
