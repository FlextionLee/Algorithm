package baekjoon;

import java.util.*;
import java.io.*;


public class SOFTEER_순서대로방문하기
{
    static int[][] map;
    static ArrayList<int[]> prio;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int lx,ly,N,count;
    static boolean[][] visited;
    public static void main(String args[])throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        N = n;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        prio = new ArrayList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int[] tmp = new int[2];
            tmp[0] = x-1;
            tmp[1] = y-1;
            prio.add(tmp);
        }
        visited = new boolean[n][n];
        lx = prio.get(prio.size()-1)[0];
        ly = prio.get(prio.size()-1)[1];

        int sx = prio.get(0)[0];
        int sy = prio.get(0)[1];
        visited[sx][sy] = true;
        ArrayList<int[]> list = new ArrayList<>();
        list.add(prio.get(0));
        dfs(sx,sy, list);
        System.out.println(count);
    }
    public static void dfs(int x, int y,ArrayList<int[]> list){
        if(x == lx && y == ly){
            int idx = 0;
            for(int i=0; i<list.size(); i++){
                int curx = list.get(i)[0];
                int cury = list.get(i)[1];
                if(curx == prio.get(idx)[0] && cury == prio.get(idx)[1]){
                    idx++;
                }
            }

            if(idx < prio.size() -1){
                return;
            }else{
                count++;
            }

            return;
        }

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny]||map[nx][ny] == 1) continue;
            int[] next = new int[2];
            next[0] = nx;
            next[1] = ny;
            list.add(next);
            visited[nx][ny] = true;
            dfs(nx,ny,list);
            list.remove(next);
            visited[nx][ny] = false;
        }
    }

}