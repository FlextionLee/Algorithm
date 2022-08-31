package swea;

import java.util.*;
import java.io.*;

/**
 * 흉악범이 탈출!
 * 어느 한 지점으로 들어감
 * 해당 파이프로 갈 수 있는 방향이 있고
 * 총 파이프 갯수는 7개이고 각 파이프 마다 연결된 모양이 다름
 * 만약 상하로 이어진 파이프에 위치해 있다고 가정 -> 상으로 갔을때 상 좌표에 있는 파이프가 하와 연결되어 있어야 이동이 가능함
 * 탈주범이 X초 뒤에 위치할 수 있는 곳의 갯수를 세어보자!
 */

public class SW1953_탈주범_검거 {
    static int T,N,M,R,C,S,ans;
    static int[][] map;
    static boolean connect[][] = {
            {},
            {true,true,true,true},
            {true,false,true,false},
            {false,true,false,true},
            {true,true,false,false},
            {false,true,true,false},
            {false,false,true,true},
            {true,false,false,true}
    };

    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            ans = 0;
            map = new int[N][M];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(R,C);
            System.out.println("#"+t+" "+ans);
        }

    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.add(new int[]{r,c,map[r][c],1});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[3] <= S){
                ans++;
            }
            if(tmp[3] > S){
                return;
            }
            for(int k=0; k<connect[tmp[2]].length; k++){
                if(connect[tmp[2]][k]){
                    int nx = tmp[0] +dx[k];
                    int ny = tmp[1] +dy[k];
                    if(nx<0||ny<0||nx>=N||ny>=M||visited[nx][ny]||map[nx][ny]==0) continue;

                    int nextNum = map[nx][ny];
                    if(connect[nextNum][(k+2)%4]){
                        q.add(new int[]{nx,ny,map[nx][ny],tmp[3]+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}

