package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1987_알파벳 {
    static int N, M;
    static int max = Integer.MIN_VALUE;
    static boolean[] alp = new boolean[26];
    static char[][] map;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        alp[map[0][0]-'A'] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }

    private static void dfs(int x, int y, int cnt) {
        max = Math.max(max,cnt);

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0||ny<0||nx>=N||ny>=M){
                continue;
            }

            if(!alp[map[nx][ny]-'A']){
                alp[map[nx][ny]-'A'] =true;
                dfs(nx,ny,cnt+1);
                alp[map[nx][ny]-'A'] =false;
            }
        }
    }
}
