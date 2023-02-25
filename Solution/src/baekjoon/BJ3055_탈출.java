package baekjoon;
import java.util.*;
import java.io.*;

public class BJ3055_탈출 {
    static int R,C,time=-1;
    static char map[][];
    static Queue<int[]> qs = new ArrayDeque<>();
    static Queue<int[]> qw = new ArrayDeque<>();
    static int[][] visitedW;
    static boolean[][] visited;
    static int[] dx= {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visitedW = new int[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j]=='S') {
                    qs.offer(new int[] {i,j,0});
                    visited[i][j] =true;

                }
                else if(map[i][j] == '*') {
                    qw.offer(new int[] {i,j,0});
                    visitedW[i][j] = 1;
                }
            }
        }

        bfs();
        bfs2();

        if(time == -1) {
            System.out.println("KAKTUS");
        }
        else {
            System.out.println(time);
        }
    }
    private static void bfs() {
        while(!qw.isEmpty()) {
            int[] tmp = qw.poll();

            for(int k=0; k<4; k++) {
                int nx = tmp[0]+dx[k];
                int ny = tmp[1]+dy[k];

                if(nx<0||ny<0||nx>=R||ny>=C||visitedW[nx][ny]!=0) {
                    continue;
                }

                if(map[nx][ny]=='.') {
                    qw.add(new int[] {nx,ny,tmp[2]+1});
                    visitedW[nx][ny] = tmp[2]+1;
                }
            }
        }
    }
    private static void bfs2() {
        while(!qs.isEmpty()) {
            int[] tmp = qs.poll();

            for(int k=0; k<4; k++) {
                int nx =tmp[0]+dx[k];
                int ny =tmp[1]+dy[k];

                if(nx<0||ny<0||nx>=R||ny>=C||visited[nx][ny]) {
                    continue;
                }
                if(map[nx][ny]=='.') {
                    if(visitedW[nx][ny]==0) {
                        qs.add(new int[] {nx,ny,tmp[2]+1});
                        visited[nx][ny] = true;
                    }
                    else {
                        if(visitedW[nx][ny] > tmp[2]+1) {
                            qs.add(new int[] {nx,ny,tmp[2]+1});
                            visited[nx][ny] = true;
                        }
                    }

                }
                if(map[nx][ny]=='D') {
                    time = tmp[2]+1;
                    return;
                }
            }
        }
    }
}
