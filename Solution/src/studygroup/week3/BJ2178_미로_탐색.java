package studygroup.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2178_미로_탐색 {
    static int N,M;
    static int min = Integer.MAX_VALUE;
    static int map[][];
    static boolean visit[][];
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        bfs();
        System.out.println(min);
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,1});
        visit[0][0] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[0] == N-1 && tmp[1] == M-1){
                min = Math.min(min,tmp[2]);
            }

            for(int k=0; k<4; k++){
                int nx = tmp[0]+dx[k];
                int ny = tmp[1]+dy[k];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny]||map[nx][ny] == 0){
                    continue;
                }
                q.add(new int[] {nx,ny,tmp[2]+1});
                visit[nx][ny] = true;
            }
        }
    }
}
