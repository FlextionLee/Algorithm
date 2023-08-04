package studygroup.Week029;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class practi{
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited= new boolean[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        visited[0][0] = true;
        dfs(0,0,"");
    }
    public static void dfs(int x, int y,String str){

        for(int i=y+1; i<m; i++){
            if(!visited[x][i]){
                visited[x][i] = true;
                dfs(x,i,str+map[x][i]);
                visited[x][i] = false;
            }
        }
        for(int i=x+1; i<n; i++){
            if(!visited[i][y]){
                visited[i][y] = true;
                dfs(i,y,str+map[x][i]);
                visited[i][y] = false;
            }
        }
    }
}
