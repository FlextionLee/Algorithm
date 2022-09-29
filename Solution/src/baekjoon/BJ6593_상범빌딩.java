package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ6593_상범빌딩 {
    static int L,R,C,ans;
    static int sh,sx,sy;
    static int eh,ex,ey;
    static char map[][][];
    static boolean visited[][][];
    static int dx[] = {0,0,-1,1,-1,1};
    static int dy[] = {1,-1,0,0,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L==0 && R==0 && C==0){
                break;
            }
            map = new char[L][R][C];
            visited = new boolean[L][R][C];

            for(int i=0; i<L; i++) {
                for(int j=0; j<R; j++){
                    char[] tmp = br.readLine().toCharArray();
                    for(int k=0; k<C; k++){
                        map[i][j][k] = tmp[k];
                        if(map[i][j][k] == 'S'){
                            sh = i;
                            sx = j;
                            sy = k;
                        }
                        else if(map[i][j][k] == 'E'){
                            eh = i;
                            ex = j;
                            ey = k;
                        }
                    }
                }
                br.readLine();
            }

            bfs(sh,sx,sy);
            if(ans != 0){
                System.out.println("Escaped in "+ans+" minute(s).");
                ans = 0;
            }
            else{
                System.out.println("Trapped!");
            }
        }
    }

    private static void bfs(int sh, int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {sh,sx,sy,0} );
        visited[sh][sx][sy] = true;

        while(!q.isEmpty()){
            int tmp[] = q.poll();
            int h = tmp[0];
            int x = tmp[1];
            int y = tmp[2];
            if(h==eh && x==ex && ey==y){
                ans = tmp[3];
                return;
            }


            for(int j=0; j<6; j++){
                if(j>3){
                    int nh = h+dx[j];
                    if(nh<0||nh>=L||visited[nh][x][y]) continue;
                    if(map[nh][x][y] == '#') continue;

                    visited[nh][x][y] = true;
                    q.add(new int[] {nh,x,y,tmp[3]+1});
                }
                else{
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(nx<0||ny<0||nx>=R||ny>=C||visited[h][nx][ny]) continue;
                    if(map[h][nx][ny] == '#') continue;

                    visited[h][nx][ny] = true;
                    q.add(new int[]{h,nx,ny,tmp[3]+1});
                }

            }


        }

    }
}
