package swea;
import java.util.*;
import java.io.*;
public class SW2105_디저트_카페 {
    static int T,N,ans;
    static int[][] map;
    static boolean[] visited;
    /**
     * 0일땐 우하 좌하
     * 1일땐 좌하 좌상
     * 2일땐 좌상 우상
     * 3일땐 우상
     */
    static boolean[][] dxy = {
            {true,true,false,false},
            {false,true,true,false},
            {false,false,true,false},
    };
    static int dx[] = {1,1,-1,-1};
    static int dy[] = {1,-1,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            ans = -1;
            visited = new boolean[101];
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0; i<N-2; i++){
                for(int j=1; j<N; j++){
                    recur(i,j,i,j,0,1);
                    visited[map[i][j]] = false;
                }
            }

            System.out.println("#"+t+" "+ans);
        }

    }

    static void recur(int tr, int tc, int nr, int nc, int dir, int sum) {
        visited[map[nr][nc]]=true;
        // 방향 초과(0~3)
        if(dir>3) return;
        // 각 방향에 따른 좌표 변화
        nr += dx[dir];
        nc += dy[dir];

        //돌아서 원래 점으로 돌아옴
        if(nr==tr && nc==tc) {
            ans = Math.max(ans, sum);
            return;
        }

        // 가장 위에 찍힌 점보다 더 위에 올라갈 수 없음.(작을 수 없음)
        if(nr<0 || nc<0 || nr> N-1|| nc>N-1) return;

        //이미 방문했던 디저트 가게라면 return
        if(visited[map[nr][nc]]) return;

        visited[map[nr][nc]]=true;
        recur(tr,tc,nr,nc, dir, sum+1);
        recur(tr,tc,nr,nc,dir+1, sum+1);
        visited[map[nr][nc]]=false;
    }//end recur
}