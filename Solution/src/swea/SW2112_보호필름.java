package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW2112_보호필름 {
    static int T,D,W,K,ans;
    static int[][] map;
    static int[][] copy;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[D][W];
            copy = new int[D][W];
            for(int i=0; i<D; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    copy[i][j] = map[i][j];
                }
            }
            ans = Integer.MAX_VALUE;
            dfs(0,0);


                System.out.println("#"+t+" "+ans);


        }

    }

    private static void dfs(int depth, int count) {
        if(check()){
            ans = Math.min(ans,count);
        }

        if(depth == D){
            return;
        }

        if(count >= ans){
            return;
        }

        dfs(depth+1, count);

        for(int i=0; i<W; i++){
            map[depth][i] = 0;
        }
        dfs(depth+1, count+1);
        for(int i=0; i<W; i++){
            map[depth][i] = copy[depth][i];
        }

        for(int i=0; i<W; i++){
            map[depth][i] = 1;
        }
        dfs(depth+1, count+1);

        for(int i=0; i<W; i++){
            map[depth][i] = copy[depth][i];
        }

    }

    private static boolean check() {

        for(int i=0; i<W; i++){
            int a = 0;
            int b = 0;
            int ma = 0;
            int mb = 0;
            for(int j=0; j<D; j++){
                if(map[j][i] == 0){
                    a++;
                    if(b > mb) mb = b;
                    b=0;
                }
                else{
                    b++;
                    if(a > ma) ma = a;
                    a= 0 ;
                }
                if(j==D-1){
                    if(b > mb) mb = b;
                    if(a > ma) ma = a;
                }
            }
            if(ma<K && mb<K){
                return false;
            }
        }
        return true;
    }
}
