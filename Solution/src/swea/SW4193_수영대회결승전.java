package swea;

//mport java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class SW4193_수영대회결승전 {
    static int ans, T, N;
    static int[][] map, cpy;

    // 상하좌우
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };


    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input2.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    map[i][j] = map[i][j] == 1 ? -1 : map[i][j];
                }

            }

            //print(map);

            ans = bfs(new Point(sc.nextInt(), sc.nextInt()), new Point(sc.nextInt(), sc.nextInt()));

            System.out.println("#" + t + " " + ans);

            // break;

        }

    } // end main


    private static int bfs(Point start, Point end) {
        // bfs
        // Q 를 만들고 하나 넣고 [하나 빼고 뺀놈과 연관된 노드를 Q에 넣는다.] 반복
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] v = new boolean[N][N];

        q.offer(start);
        v[start.r][start.c] = true;

        int time = 0;
        while (!q.isEmpty()) {
            // 지도는 3타임마다 초기화
            if (time % 3 == 0) cpy = mapCpy(map);

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point p = q.poll();

                // 도착
                if (p.r == end.r && p.c == end.c) {
                    System.out.println(time);
                }

                for (int d = 0; d < 4; d++) {
                    int nr = p.r + dy[d];
                    int nc = p.c + dx[d];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if (v[nr][nc]) continue;

                    if (cpy[nr][nc] > 0) q.offer(p);

                    if (cpy[nr][nc] == 0) {
                        v[nr][nc] = true;
                        q.offer(new Point(nr, nc));
                    }

                }

            }

            time++;

            // 한 타임이 지날때마다 소용돌이S 값을 1씩 빼준다.
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    cpy[r][c] = cpy[r][c] > 0 ? cpy[r][c] - 1 : cpy[r][c];
                    if (cpy[r][c] > 0) cpy[r][c]--;
                }

            }

        }

        return -1; // 도착할 수 없다면

    } // end bfs


    private static int[][] mapCpy(int[][] map) {
        int[][] cpy = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) cpy[i] = map[i].clone();
        return cpy;
    } // end mapCpy


    private static void print(int[][] map) {
        for (int i = 0; i < N; i++) System.out.println(Arrays.toString(map[i]));
        System.out.println();

    } // end print


    static class Point {
        int r, c;


        public Point(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }


        @Override
        public String toString() {
            return "Point [r=" + r + ", c=" + c + "]";
        }

    } // end Point
}

