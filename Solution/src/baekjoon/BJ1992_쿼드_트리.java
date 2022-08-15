package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1992_쿼드_트리 {
    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j]= str.charAt(j)-'0';
            }
        }

        dfs(N,0,0);
        System.out.println(sb);
    }

    private static void dfs(int n, int x, int y) {

        if(colorCheck(n,x,y)){
            sb.append(map[x][y]);
            return;
        }

        sb.append('(');

        int size = n/2;

        dfs(size,x,y);

        dfs(size,x,y+size);

        dfs(size,x+size,y);

        dfs(size,x+size,y+size);
        sb.append(')');
    }

    private static boolean colorCheck(int n, int x, int y) {
        int t = map[x][y];

        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(map[i][j] != t){
                    return false;
                }
            }
        }
        return true;
    }
}
