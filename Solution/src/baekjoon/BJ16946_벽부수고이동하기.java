package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ16946_벽부수고이동하기 {
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited;
    static int[][] ans;
    static int[][] group;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        ans = new int[n][m];
        group = new int[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        visited = new boolean[n][m];
        int groupCount = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    bfs(i,j,n,m,groupCount);
                    groupCount++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1){
                    int sum = 0;
                    HashSet<Integer> set = new HashSet<>();
                    for(int k=0; k<4; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx<0||ny<0||nx>=n||ny>=m) continue;
                        if(set.contains(group[nx][ny])) continue;
                        sum += ans[nx][ny];
                        set.add(group[nx][ny]);
                    }
                    map[i][j] = sum+1;
                }
                sb.append(map[i][j]%10);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int bfs(int i, int i1, int n, int m, int gc) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,i1});
        int count = 0;
        visited[i][i1] = true;
        ArrayList<int[]> list = new ArrayList<>();

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            list.add(new int[]{tmp[0],tmp[1]});
            group[tmp[0]][tmp[1]] = gc;
            count++;
            for(int d=0; d<4; d++){
                int nx = tmp[0]+dx[d];
                int ny = tmp[1]+dy[d];

                if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny]||map[nx][ny]==1)continue;
                q.add(new int[]{nx,ny});
                visited[nx][ny] = true;
            }
        }
        for(int[] t : list){
            ans[t[0]][t[1]] = count;
        }
        return count;
    }
}
