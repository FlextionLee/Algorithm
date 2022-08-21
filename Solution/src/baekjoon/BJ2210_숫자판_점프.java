package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2210_숫자판_점프 {
    static int n;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static HashSet<String> hashset = new HashSet<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        arr = new int[5][5];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                dfs(i,j,0,arr[i][j]+"");
            }
        }

        System.out.println(hashset.size());
    }
    public static void dfs(int x, int y, int cnt, String s) {
        if(cnt == 5) {
            hashset.add(s);
            return;
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                continue;
            }
            dfs(nx,ny,cnt+1,s+arr[nx][ny]);
        }
    }
}
