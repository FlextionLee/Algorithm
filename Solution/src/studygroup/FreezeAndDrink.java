package studygroup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class FreezeAndDrink {
    static int N,M,COUNT;
    static boolean visited[][];
    static int map[][];
    static Queue<int[]> q;
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        q = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j] || map[i][j] == 1) {
                    continue;
                }
                q.add(new int[] {i,j});
                visited[i][j] = true;
                bfs();
                COUNT++;
            }
        }
        System.out.println(COUNT);
    }

    private static void bfs() {
        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int k=0; k<4; k++){
                int nx = tmp[0]+dx[k];
                int ny = tmp[1]+dy[k];

                if(nx<0 || ny<0 || nx>=N || ny>= M || visited[nx][ny] || map[nx][ny]==1){
                    continue;
                }
                q.add(new int[] {nx,ny});
                visited[nx][ny] = true;
            }
        }
    }
}
