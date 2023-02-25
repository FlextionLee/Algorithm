package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1486_장훈이의높은선반 {
    static int T,N,B,ans;
    static int[] heights;
    static int mheight;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            heights = new int[N];
            ans = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0,  0);
            System.out.println("#" + t + " " + (ans - B));
        }
    }

    private static void dfs(int depth, int height) {
        if(height >= B){
            //System.out.println("here");
            ans = Math.min(ans, height);
        }
        if(depth == N){
            return;
        }

        dfs(depth+1, height+heights[depth]);
        dfs(depth+1, height);
    }
}
