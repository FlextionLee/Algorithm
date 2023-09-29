package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2146_다리만들기 {

    static final int[] dx= {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static int[][] map;
    static boolean[][] visited;
    static int N, num=1, res=Integer.MAX_VALUE;

    static class point{
        int x;
        int y;
        int cnt;

        point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬에 번호 부여
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j]!=0){
                    makeLand(i,j);
                    ++num;
                }
            }
        }

        // visited 초기화
        clear_visited();

        // 다리만들기
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]!=0){
                    bfs(i, j, map[i][j]);
                    clear_visited();
                }
            }
        }

        System.out.println(res);
    }

    // 섬에 번호 부여
    private static void makeLand(int x, int y) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] {x, y});
        visited[x][y] = true;
        map[x][y] = num;

        while (!que.isEmpty()) {
            int[] now = que.poll();

            for (int i=0; i<4; ++i) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if (nextX>=0 && nextY>=0 && nextX<N && nextY<N){
                    if(map[nextX][nextY]==1 && !visited[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        map[nextX][nextY] = num;
                        que.add(new int[] {nextX, nextY});
                    }
                }
            }
        }
    }

    // 다리만들기
    public static void bfs(int x, int y, int start){
        Queue<point> que = new ArrayDeque<>();
        que.add(new point(x, y, 0));
        visited[x][y] = true;

        while(!que.isEmpty()){
            point temp = que.poll();
            int nowX = temp.x;
            int nowY = temp.y;
            int cnt = temp.cnt;

            for(int i=0; i<4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX>=0 && nextY>=0 && nextX<N && nextY<N){
                    if(!visited[nextX][nextY]){
                        // 다리놓기
                        if(map[nextX][nextY]==0){
                            visited[nextX][nextY] = true;
                            que.offer(new point(nextX, nextY, cnt+1));
                        }
                        // 다른 섬 도달, 다리 길이 비교
                        else if(map[nextX][nextY]!=0 && map[nextX][nextY]!=start){
                            res = Math.min(res, cnt);
                            que.clear();
                            return;
                        }
                    }
                }
            }
        }
    }

    // visited 초기화
    private static void clear_visited(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                visited[i][j] = false;
            }
        }
    }
}