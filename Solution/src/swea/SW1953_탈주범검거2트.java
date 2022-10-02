package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW1953_탈주범검거2트 {
    /**
     * 맨홀뚜껑을 통해 지하 어느 한 지점으로 들어감
     * 터널끼리 연결되어있다면 이동이 가능함
     * 탈주범이 있을 수 있는 위치의 개수를 계산
     * 시간당 1의 거리를 움직임
     */
    static int T,N,M,R,C,L,ans;
    static int map[][];
    static boolean visited[][];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    //상좌하우
    static boolean[][] dxy = {
            {},
            {true,true,true,true},
            {true,false,true,false},
            {false,true,false,true},
            {true,false,false,true},
            {false,false,true,true},
            {false,true,true,false},
            {true,true,false,false}
    };
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            for(int i=0; i<N; i++){
                st= new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = bfs(R,C);

            System.out.println("#"+t+" "+ans);
        }

    }

    private static int bfs(int r , int c) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[r][c] = true;
        q.add(new int[] {r,c,map[r][c],1});
        int count = 1;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            if(tmp[3] == L){
                break;
            }

            for(int k=0; k<4; k++){
                if(dxy[tmp[2]][k]){
                    int nx = tmp[0] + dx[k];
                    int ny = tmp[1] + dy[k];

                    if(nx<0||ny<0||nx>=N||ny>=M||visited[nx][ny]||map[nx][ny]==0) continue;
                    if(dxy[map[nx][ny]][(k+2)%4]){
                        visited[nx][ny] = true;
                        q.add(new int[] {nx,ny,map[nx][ny],tmp[3]+1});
                        count++;
                    }
                }
            }
        }
        return count;
    }


}
