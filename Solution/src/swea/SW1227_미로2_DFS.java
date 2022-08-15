package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW1227_미로2_DFS {
    static int[][] map;
    static boolean visited[][];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int answer = 0;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++){
            br.readLine();
            StringBuilder sb = new StringBuilder("#").append(t).append(" ");
            map = new int[100][100];
            visited = new boolean[100][100];

            for(int i=0; i<100; i++){
                String str = br.readLine();
                for(int j=0; j<100; j++){
                    map[i][j] = str.charAt(j) - 48;
                }
            }

            dfs(1,1);
            sb.append(answer);
            System.out.println(sb);
            answer = 0;
        }
    }

    private static void dfs(int x,int y) {
        if(map[x][y] == 3){
            answer = 1;
            return;
        }
        for(int k=0; k<4; k++){
            int nx = x+dx[k];
            int ny = y+dy[k];

            if(nx<0||ny<0||nx>=100||ny>=100||map[nx][ny]==1||visited[nx][ny]){
                continue;
            }
            visited[nx][ny] =true;
            dfs(nx,ny);
        }
    }
}
