package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17142_연구소3 {
    static int[][] map,origin;
    static ArrayList<int[]> posList;
    static boolean[] target;
    static int N;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int ans = Integer.MAX_VALUE;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        N = n;
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        origin = new int[n][n];
        posList = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = origin[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    map[i][j] = origin[i][j] = -1;
                }
                if(map[i][j] == 1){
                    map[i][j] = origin[i][j] = -3;
                }
                if(map[i][j] == 2){
                    posList.add(new int[]{i,j});
                    map[i][j] = origin[i][j] = -2;
                }
            }
        }

        if(isPossible() != Integer.MAX_VALUE){
            System.out.println(0);
            return;
        }
        target = new boolean[posList.size()];
        dfs(0,0,m);
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }

    private static void dfs(int dep, int count, int m) {
        if(count == m){
            ArrayList<int[]> tmpList = new ArrayList<>();
            for(int i=0; i<target.length; i++){
                if(target[i]){
                    tmpList.add(new int[]{posList.get(i)[0],posList.get(i)[1]});
                }
            }
            bfs(tmpList);

            ans = Math.min(ans, isPossible());
            for(int i=0; i<N; i++){
                map[i] = origin[i].clone();
            }
            return;
        }
        if(dep == target.length) return;
        target[dep] = true;
        dfs(dep+1,count+1, m);
        target[dep] = false;
        dfs(dep+1,count,m);
    }

    private static int isPossible() {
        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == -1) return Integer.MAX_VALUE;
                if(origin[i][j] == -1){
                    max = Math.max(max,map[i][j]);
                }
            }
        }
        return max;
    }

    private static void bfs(ArrayList<int[]> list) {
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[N][N];
        for(int[] i : list){
            q.add(new int[]{i[0],i[1],0});
            visited[i[0]][i[1]] = true;
            map[i[0]][i[1]] = 0;
        }

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int i=0; i<4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny]||map[nx][ny]==-3)continue;
                map[nx][ny] = tmp[2]+1;
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny,map[nx][ny]});
            }
        }
    }
}
