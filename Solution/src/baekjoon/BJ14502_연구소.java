package baekjoon;

import java.io.*;
import java.util.*;
public class BJ14502_연구소 {
/*    맵에 바이러스가 퍼지기 전에 연구소에 벽을 세우려함
    바이러스는 상하좌우 인접한 빈 칸으로 모두 퍼져나갈 수 있음
    벽은 3개 세울 수 있고 꼭 3개 세워야 함 안전영역의 최대 값은?*/
    static int N,M;
    static int max = Integer.MIN_VALUE;
    static int[][] map;
    static int[][] tmp;
    static boolean[][] visited;
    static List<int []> zeroList= new ArrayList<>();
    static Point[] tmpList = new Point[3];
    static List<Point[]> combList= new ArrayList<>();

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    zeroList.add(new int[]{i, j});
                }
            }
        }
        comb(0,0);
            for(int i=0; i<combList.size(); i++){

                tmp = new int[N][M];

                for(int j=0; j<N; j++){
                    tmp[j] = map[j].clone();
                }
                for(int j=0; j<3; j++){
                    Point p = combList.get(i)[j];
                    tmp[p.x][p.y] = 1;
                }

                for(int r=0; r<N; r++){
                    for(int t=0; t<M; t++){
                        if(tmp[r][t]==2){
                            bfs(r,t);
                        }
                    }
                }

                int count = 0;
                for(int r=0; r<N; r++){
                    for(int t=0;t<M; t++){
                        if(tmp[r][t] == 0){
                            count++;
                        }
                    }
                }
                max = Math.max(max,count);
                visited = new boolean[N][M];
            }
        System.out.println(max);
    }

    private static void bfs(int r, int t) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(r,t));
        visited[r][t] = true;

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int k=0; k<4; k++){
                int nx = p.x+dx[k];
                int ny = p.y+dy[k];

                if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny] || tmp[nx][ny] == 1){
                    continue;
                }
                if(tmp[nx][ny]==0) {
                    q.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                    tmp[nx][ny] = 2;
                }
            }
        }
    }

    private static void comb(int depth, int start) {
        if(depth == 3){
            combList.add(new Point[]{tmpList[0],tmpList[1],tmpList[2]});
            return;
        }

        for(int i=start; i<zeroList.size(); i++){
            tmpList[depth] = new Point(zeroList.get(i)[0],zeroList.get(i)[1]);
            comb(depth+1, i+1);
        }
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
