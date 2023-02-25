package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW5208_전기버스2 {
    static int T,N,ans;
    static int[] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N-1];
            ans = Integer.MAX_VALUE;
            for(int i=0; i<N-1; i++){
                map[i]=Integer.parseInt(st.nextToken());
            }

            dfs(1,0,map[0]);
            System.out.println("#"+t+" "+ans);
        }
    }

    private static void dfs(int depth, int count, int amount) {
        //System.out.println(amount);
        if(depth == N-1){
            ans = Math.min(ans ,count);
            //System.out.println(count);
            return;
        }
        if(count > ans){
            return;
        }

        if(amount < 1){
            return;
        }

        dfs(depth+1,count,amount-1);
        dfs(depth+1,count+1,map[depth]);

    }
}
