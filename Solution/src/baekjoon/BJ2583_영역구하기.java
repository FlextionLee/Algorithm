package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2583_영역구하기 {
    static int N,M,K,answer;
    static int map[][];
    static boolean[][] visited;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<K; i++){
            st= new StringTokenizer(br.readLine());
            int ldx = Integer.parseInt(st.nextToken());
            int ldy = Integer.parseInt(st.nextToken());
            int rux = Integer.parseInt(st.nextToken());
            int ruy = Integer.parseInt(st.nextToken());

            for(int j = N-ruy; j<N-ldy; j++){
                for(int k= ldx;k<rux; k++){
                    map[j][k] = 1;
                }
            }
        }
       ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && map[i][j] == 0){
                    list.add(bfs(i,j));
                    answer++;
                }
            }
        }

        Collections.sort(list);

        System.out.println(answer);
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }

    }

    private static int bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {i,j});
        visited[i][j] = true;
        int count = 1;

        while(!q.isEmpty()){
            int tmp[] = q.poll();

            for(int k=0; k<4; k++){
                int nx = tmp[0] + dx[k];
                int ny = tmp[1] + dy[k];

                if(nx<0||ny<0||nx>=N||ny>=M||visited[nx][ny]) continue;
                if(map[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
