package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1861_정사각형_방 {
    static int T,N;
    static int[][] arr;
    static StringTokenizer st;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int count = 1;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int roomNum = 0;
            int max =0;
            sb = new StringBuilder();

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    dfs(i,j);
                    int num =  arr[i][j];
                    if(max <= count){
                        max = count;
                        roomNum = num;
                    }
                    else if(max ==count){
                        roomNum = (roomNum < num)?roomNum:num;
                    }
                    count = 1;
                }
            }
            sb.append("#").append(t).append(" ").append(roomNum).append(" ").append(max).append("\n");
            System.out.print(sb.toString());
        }
    }

    private static void dfs(int x, int y) {
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx < 0 || ny < 0 || nx>=N || ny>=N || arr[nx][ny]-arr[x][y]!=1){
                continue;
            }
            count++;
            dfs(nx,ny);
        }
        return;
    }
}
