package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SW2819_격자판숫자이어붙이기 {
    static int T;
    static char map[][];
    static HashSet<String> set = new HashSet<>();
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            set.clear();
            map = new char[4][4];
            for(int i=0; i<4; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<4; j++){
                    map[i][j] = st.nextToken().charAt(0);
                }
            }

            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    dfs(0,i,j,"");
                }
            }

            System.out.println("#"+t+" "+set.size());
        }
    }

    private static void dfs(int depth,int x, int y, String s) {
        if(depth == 7){
            set.add(s);
            return;
        }

        for(int i=0; i<4; i++){
            int nx = dx[i]+x;
            int ny = dy[i]+y;

            if(nx<0||ny<0||nx>=4||ny>=4) continue;
            dfs(depth+1,nx,ny,s+map[nx][ny]);
        }
    }
}
