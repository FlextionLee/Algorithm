package studygroup.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class PopulationMovement {
    static int N,L,R,sum=0,answer=0;
    static int[][] map;
    static boolean[][] visited;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};
    static Queue<int[]> q = new ArrayDeque<>();
    static Queue<int[]> tmpq = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]){
                    continue;
                }
                bfs(i,j);
                if(tmpq.size()==1){
                    tmpq.clear();
                    sum = 0;
                }
                else{
                    int avg = sum/tmpq.size();
                    for(int[] a : tmpq){
                        map[a[0]][a[1]] = avg;
                    }
                    for(int x=0; x<N; x++) {
                        for (int y = 0; y < N; y++) {
                            System.out.print(map[x][y]+" ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println(i+" "+j);

                    tmpq.clear();
                    sum = 0;
                    i=0;
                    j=0;
                    answer++;
                    visited = new boolean[N][N];
                }
            }
        }
    }

    private static void bfs(int i,int j) {
        q.add(new int[]{i,j});
        tmpq.add(new int[] {i,j});
        sum += map[i][j];
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[]tmp=q.poll();

            for(int k=0; k<4; k++){
                int nx = tmp[0]+dx[k];
                int ny = tmp[1]+dy[k];

                if(nx < 0 || ny < 0 || ny >= N|| nx >= N || visited[nx][ny]){
                    continue;
                }
                int abs = Math.abs(map[tmp[0]][tmp[1]] - map[nx][ny]);

                if(abs >= L && abs <= R){
                    q.add(new int[]{nx,ny});
                    tmpq.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    sum += map[nx][ny];
                }
            }
        }
    }
}
