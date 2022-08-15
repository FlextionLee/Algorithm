package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2630_색종이_만들기 {
    static int N,ONE,ZERO;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(N,0,0);
        System.out.println(ZERO);
        System.out.println(ONE);
    }

    private static void dfs(int n,int x,int y) {
        if(check(x,y,n)){
            if(map[x][y]==0){
                ZERO++;
            }
            else{
                ONE++;
            }
            return;
        }

        int size = n/2;

        dfs(size,x,y);
        dfs(size,x,y+size);
        dfs(size,x+size,y);
        dfs(size,x+size,y+size);
    }
    private static boolean check(int row,int col,int size){

        int t = map[row][col];

        for(int i =row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(map[i][j] != t) return false;
            }
        }
        return true;
    }
}
