import java.io.*;
import java.util.*;

public class SW_기지국 {

    static StringBuilder sb = new StringBuilder();
    static int T, W, H, ans;    // 가로랑 세로 순으로 줌
    static int[][] input;
    static boolean[][] visited;
    static int[][][] dt = {
            {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, 1}, {-1, -1}},    // x 가 짝수 --> 윗좌우까지
            {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {1, -1}}        // x 가 홀수 --> 아래좌우까지
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            stk = new StringTokenizer(br.readLine());
            W = Integer.parseInt(stk.nextToken());
            H = Integer.parseInt(stk.nextToken());
            input = new int[H][W];
            visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                stk = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    input[i][j] = Integer.parseInt(stk.nextToken());
                }
            }

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    dfs(i, j, 0, 0);
                }
            }

            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int y, int x, int cnt, int sum) {
        if (cnt == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < 6; i++) {
            int ny = y + dt[(x&1)][i][0];
            int nx = x + dt[(x&1)][i][1];

            if (ny<0 || nx<0 || ny>=H || nx>=W) continue;
            if (visited[ny][nx]) continue;

            visited[ny][nx] = true;
            dfs(ny, nx, cnt+1, sum+input[ny][nx]);
            visited[ny][nx] = false;
        }
    }

}