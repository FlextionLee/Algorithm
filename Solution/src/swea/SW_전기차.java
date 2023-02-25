import java.io.*;
import java.util.*;

public class SW_전기차 {

    static StringBuilder sb = new StringBuilder();
    static int T, N, ans;
    static int[][] input;
    static boolean[][] visited;
    static List<int[]> hl = new ArrayList<>();
    static List<int[]> cl = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            hl.clear();
            input = new int[31][31];
            visited = new boolean[31][31];
            ans = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                stk = new StringTokenizer(br.readLine());
                int hx = Integer.parseInt(stk.nextToken());
                int hy = Integer.parseInt(stk.nextToken());
                int d = Integer.parseInt(stk.nextToken());

                hl.add(new int[] {hy+15, hx+15, d});
                visited[hy+15][hx+15] = true;
            }

            check();
            find(N);
            if (!cl.isEmpty()) solve1();
            else {
                find(1);    // 여기서 생성된 cl 원소 중 두개를 골라서 최소를 구해야 함
                solve2();
            }

            sb.append('#').append(t).append(' ').append(ans == Integer.MAX_VALUE ? -1 : ans).append('\n');
        }

        System.out.print(sb);
    }

    static void solve1() {
        for(int[] ch : cl) {
            int tmp = 0;
            for(int[] home : hl) {
                tmp += getDist(ch[0], ch[1], home[0], home[1]);
            }
            ans = Math.min(ans, tmp);
        }
    }

    static void solve2() {
        int[] c1 = null; int[] c2 = null;

        for (int i = 0; i < cl.size(); i++) {
            for (int j = i+1; j < cl.size(); j++) {
                boolean flag = true;
                c1 = cl.get(i); c2 = cl.get(j);
                int tmp = 0;

                for(int[] home : hl) {
                    int ttmp = Math.min(getDist(c1[0], c1[1], home[0], home[1]), getDist(c2[0], c2[1], home[0], home[1]));
                    if (ttmp > home[2]) {
                        flag = false;
                        break;
                    }
                    tmp += ttmp;
                }
                if (flag) ans = Math.min(ans, tmp);
            }
        }
    }

    static void find(int n) {
        cl.clear();

        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 31; j++) {
                if (input[i][j] >= n && !visited[i][j]) cl.add(new int[] {i, j});
            }
        }
    }

    static void check() {
        for(int[] home : hl) {
            for (int i = 0; i < 31; i++) {
                for (int j = 0; j < 31; j++) {
                    if (getDist(home[0], home[1], i, j) <= home[2] && getDist(home[0], home[1], i, j) > 0) input[i][j]++;
                }
            }
        }
    }

    static int getDist(int y1, int x1, int y2, int x2) {
        return Math.abs(y1-y2) + Math.abs(x1-x2);
    }
}