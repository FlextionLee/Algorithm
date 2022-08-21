package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16926_배열_돌리기{

    static int N,M,R;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 처리
        for (int i=0; i<R; i++) {
            rotate();
        }
        // 출력
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void rotate() {
        int sx = 0, ex = N-1;
        int sy = 0, ey = M-1;

        while(true) {
            //기저 조건
            if(ex - sx < 1 || ey-sy < 1) break;

            //반시계 방향으로 이동
            int temp = map[sx][sy];//복사

            // top 좌로 이동
            for(int i=sy; i<ey; i++) {
                map[sx][i] = map[sx][i+1];
            }

            //right 상으로 이동
            for(int i=sx; i<ex; i++) {
                map[i][ey] = map[i+1][ey];
            }

            //bottom 우로 이동
            for(int i=ey; i>sy; i--) {
                map[ex][i] =map [ex][i-1];
            }

            //left 하로 이동
            for(int i = ex; i>sx; i--) {
                map[i][sy]= map[i-1][sy];
            }
            map[sx+1][sy] = temp;

            sx+=1;
            sy+=1;
            ex-=1;
            ey-=1;
        }
    }



}
