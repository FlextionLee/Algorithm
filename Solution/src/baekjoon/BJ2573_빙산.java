package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2573_빙산 {
    static int N,M,ans;
    static boolean check = false;
    static int[][] map;
    static boolean[][] visited;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        while(!check) {
            ans++;
            simulation();
        }
        System.out.println(ans);
    }

    private static void simulation() {
        //얼마나 지워지는지 리스트에 담음
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != 0){
                    int count = 0;
                    for(int k=0; k<4; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx<0||ny<0||nx>=N||ny>=M) continue;
                        if(map[nx][ny] == 0){
                            count++;
                        }
                    }
                    list.add(new int[] {i,j,count});
                }
            }
        }

        //리스트에서 꺼내서 지워진 값 처리
        for(int[] tmp : list){
            int x= tmp[0];
            int y = tmp[1];
            int count = tmp[2];
            if(map[x][y]-count > 0){
                map[x][y] = map[x][y]-count;
            }else{
                map[x][y] = 0;
            }
        }

        int end =0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    end++;
                }
            }
        }
        if(end == N*M){
            check = true;
            ans = 0;
            return;
        }

        //bfs 돌리면서 빙산이 쪼개졌는지 확인하기
        visited = new boolean[N][M];
        int ccount = 0;

        loop:
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != 0 && !visited[i][j]) {
                    bfs(i, j);
                    ccount++;
                    if(ccount > 1) {
                        check = true;
                        break loop;
                    }
                }
            }
        }

    }

    private static void bfs(int i, int j) {
        visited[i][j] = true;
        Queue<int[]> q= new ArrayDeque<>();
        q.add(new int[] {i,j});

        while(!q.isEmpty()){
            int tmp[] = q.poll();

            for(int k=0; k<4; k++){
                int nx = tmp[0] + dx[k];
                int ny = tmp[1] + dy[k];
                if(nx<0||ny<0||nx>=N||ny>=M||visited[nx][ny]) continue;
                if(map[nx][ny] != 0){
                    q.add(new int[] {nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
