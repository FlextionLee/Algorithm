package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW8382_방향전환 {
    static int T,sx,sy,ex,ey,ans;
    //상우하좌
    static int dx[]={-1,0,1,0};
    static int dy[]={0,-1,0,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken())+100;
            sy = Integer.parseInt(st.nextToken())+100;
            ex = Integer.parseInt(st.nextToken())+100;
            ey = Integer.parseInt(st.nextToken())+100;

            ans = Integer.MAX_VALUE;
            bfs(sx,sy,0);
            bfs(sx,sy,1);
            System.out.println("#"+t+" "+ans);
        }
    }

    private static void bfs(int sx, int sy,int i) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[201][201];
        q.add(new int[]{sx,sy,i});
        visited[sx][sy] = true;

        while(!q.isEmpty()){
            int tmp[] = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int judge = tmp[2];

            if(x==ex && y ==ey){
                if(i==1){
                    ans = Math.min(ans,judge-1);
                }
                else{
                    ans = Math.min(ans,judge);
                }
            }

            if(judge%2==0){
                if(x-1 >= 0 && !visited[x-1][y]){
                    q.add(new int[]{x-1,y,judge+1});
                    visited[x-1][y] =true;
                }
                if(x+1<=200 && !visited[x+1][y]) {
                    q.add(new int[]{x + 1, y, judge + 1});
                    visited[x + 1][y] = true;
                }
            }
            else{
                if(y-1>=0 && !visited[x][y-1]){
                    q.add(new int[]{x,y-1,judge+1});
                    visited[x][y-1] = true;
                }
                if(y+1<=200 && !visited[x][y+1]){
                    q.add(new int[]{x,y+1,judge+1});
                    visited[x][y+1] = true;
                }
            }
        }
    }

}
