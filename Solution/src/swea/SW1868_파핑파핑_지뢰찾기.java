package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SW1868_파핑파핑_지뢰찾기 {
    static int T,N,ans;
    static int map[][];
    static class Click{
        int x,y;
        public Click(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    static int[] dx = {0,0,-1,1,1,1,-1,-1};
    static int[] dy = {-1,1,0,0,-1,1,1,-1};
    static Queue<int[]> q;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            ans = 0;

            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<N; j++){
                    if(str.charAt(j)=='*'){
                        map[i][j] = -2;
                    }
                    else{
                        map[i][j] = -1;
                    }
                }
            }
            visited = new boolean[N][N];
            q = new ArrayDeque<>();

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] == -1){
                        boolean ch = true;
                        for(int k=0; k<8; k++){
                            int nx = i+dx[k];
                            int ny = j+dy[k];

                            if(nx<0||ny<0||nx>=N||ny>=N) continue;
                            if(map[nx][ny]==-2) {
                                ch = false;
                                break;
                            }
                        }
                        if(ch){
                            bfs(i,j);
                            ans++;
                        }
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] == -1) ans++;
                }
            }
            System.out.println("#"+t+" "+ans);
        }
    }

    private static void bfs(int i, int j) {
        q.offer(new int[] {i,j});
        visited[i][j] = true;
        map[i][j] = 0;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            boolean ch = true;

            for(int k=0; k<8; k++){
                int nx = tmp[0] + dx[k];
                int ny = tmp[1] + dy[k];

                if(nx<0||ny<0||nx>=N||ny>=N) continue;
                if(map[nx][ny] == -2){
                    ch =false;
                    break;
                }
            }
            if(ch){
                for(int k=0; k<8; k++){
                    int nx = tmp[0] + dx[k];
                    int ny = tmp[1] + dy[k];

                    if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny]) continue;
                        map[nx][ny] = 0;
                        visited[nx][ny] = true;
                        q.add(new int[] {nx,ny});
                }
            }
        }
    }
}
