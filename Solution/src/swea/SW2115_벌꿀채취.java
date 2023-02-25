package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW2115_벌꿀채취{
    static int T,N,M,C,ans;
    static int[][] map;
    static int[][] profit;

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j ++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            maxProfit();
            // 꿀 채취
            getHoney();

            System.out.println("#" + t + " " + ans);
        }
    }

    static void getHoney() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N-M; j++) {
                comb(i, j+M, 1, profit[i][j]);
            }
        }
    }

    static void comb(int x, int y, int cnt, int total) {
        if(cnt == 2) {
            ans = Math.max(ans, total);
            return;
        }

        for (int i = x; i < N; i++) {
            for (int j = y; j <= N-M; j++) {
                comb(i, j, cnt + 1, total + profit[i][j]);
            }
            y = 0;
        }
    }

    static void maxProfit() {
        profit = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N-M; j++) {
                ans = Integer.MIN_VALUE;
                subset(i, j, 0, 0, 0);
            }
        }
    }

    static void subset(int x, int y, int cnt, int sum, int total) {
        if(sum > C) return;

        if(cnt == M) {
            profit[x][y-M] = Math.max(profit[x][y-M], total);
            return;
        }

        subset(x, y + 1, cnt + 1, sum + map[x][y], total + map[x][y]*map[x][y]);
        subset(x, y + 1, cnt + 1, sum, total);
    }

}