package swea;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW4014_활주로건설{
    static int T,N,X,ans;
    static int[][] map;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            ans = 0;
            map = new int[N][N];
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //가로체크
            checkRow();

            //세로체크
            //checkCol();
            System.out.println(ans);
        }
    }

    private static void checkRow() {
        for(int i=0; i<N; i++){
            visited = new boolean[N];
            for(int j=0; j<N-X; j++){
                if(map[i][j]-1 == map[i][j+1] && !visited[j+1]){
                    int tmp = map[i][j+1];
                    boolean ch = true;
                    for(int k=j+1; k<j+1+X; k++){
                        if(map[i][k] != tmp){
                            ch = false;
                            break;
                        }
                    }
                    if(ch){
                        for(int k=j+1; k<j+1+X; k++){
                            visited[k] = true;
                        }
                    }
                }
                if(map[i][j]+1 == map[i][j+1]&&!visited[j+1]){
                    int tmp = map[i][j+1-X];
                    boolean ch = true;
                    for(int k=j+1-X; k<j+1; k++){
                        if(map[i][k] != tmp){
                            ch = false;
                            break;
                        }
                    }
                    if(ch){
                        for(int k=j+1-X; k<j+1; k++){
                            visited[k] = true;
                        }
                    }
                }
            }


        }
    }
}
