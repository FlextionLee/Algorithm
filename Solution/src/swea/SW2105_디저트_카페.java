package swea;

import com.sun.xml.internal.bind.v2.model.core.MaybeElement;

import java.util.*;
import java.io.*;
public class SW2105_디저트_카페 {
    static int T,N,max;
    static int[][] map;
    static int[] dessert;
    static int[] dx = {1,1,-1,-1};
    static int[] dy = {1,-1,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = -1;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    dessert = new int[101];
                    dessert[map[i][j]] = 1;
                    dfs(i,j,-1,-1,i,j,0,1);
                }
            }
            System.out.println(max);
        }
    }

    /**
     * 우하->좌하->좌상->우상
     * 4각형이 그려지는가? -> 가지치기 측면
     * 디저트를 이미 먹었나?
     * 이전꺼에 가면안됨 -> 4방탐색 후 결정값이 내가 이전에 결정한 곳이면 가면안되니까
     *
     * 처음 지점으로 돌아왔다면 맥스 갱신해주기
     */
    private static void dfs(int i, int j,int prevx, int prevy, int ni,int nj, int mode,int count) {
        for(int k=mode; k<4; k++){
            int nx = ni+dx[k];
            int ny = nj+dy[k];

            if(nx<0||nx>=N||ny<0||ny>=N) continue;
            if(nx==prevx && ny==prevy) continue;
            if(i==nx && j==ny) {
                max = Math.max(max, count);
                return;
            }
            if(dessert[map[nx][ny]] != 0) continue;

            dessert[map[nx][ny]] = 1;
            dfs(i,j,ni,nj,nx,ny,k,count+1);
            dessert[map[nx][ny]] = 0;
        }
    }
}
