package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1446_지름길 {
        static class ShortPath {
            int from, to, dist;

            public ShortPath(int from, int to, int dist) {
                this.from = from;
                this.to = to;
                this.dist = dist;
            }
        }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            ArrayList<ShortPath> path = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                if (to > d) continue; // 역주행은 할 수 없다.
                if (to - from <= dist) continue; // 지름길이 아닌 것
                path.add(new ShortPath(from, to, dist));
            }

            // 길 앞에서부터 순서대로 정렬
            Collections.sort(path, new Comparator<ShortPath>() {
                public int compare(ShortPath o1, ShortPath o2) {
                    if (o1.from == o2.from) return Integer.compare(o1.to, o2.to);
                    return Integer.compare(o1.from, o2.from);
                }
            });

            // 탐색 시작
            int move = 0;
            int dp[] = new int[d + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            int idx = 0;
            while (move < d) {
                //idx가 지름길의 길이보다 작을때
                if (idx < path.size()) {
                    ShortPath sp = path.get(idx);
                    //현재 위치가 출발지와 같다면
                    if (move == sp.from) {
                        //dp의 도착위치는 현재 위치 + 도착점 까지의 거리 or 현재 도착지의 최단거리
                        dp[sp.to] = Math.min(dp[move] + sp.dist, dp[sp.to]);
                        //다음 지름길을 조회
                        idx++;
                        //현재 위치가 출발지와 다르다면
                    } else {
                        dp[move + 1] = Math.min(dp[move + 1], dp[move] + 1);
                        move++;
                    }
                //idx가 사이즈 보다 커졌을때
                } else {
                    dp[move + 1] = Math.min(dp[move + 1], dp[move] + 1);
                    move++;
                }
            }
            System.out.println(dp[d]);
        }
}
