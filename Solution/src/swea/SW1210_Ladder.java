package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1210_Ladder {

    static int[][] map = new int[100][100];
    static int[] dx = {0,0,-1};
    static int[] dy = {-1,1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc<=10 ; tc++){
            br.readLine();

            for(int i=0; i<100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int y = 0;
            int x = 99;
            int idx = 0;

            for(int i=0; i<100; i++){
                if(map[99][i] == 2){
                    y = i;
                    break;
                }
            }

            while(true){
                if(x==0){
                    break;
                }
                for(int i=0;  i<3; i++){
                    int nx = x+dx[i];
                    int ny = y+dy[i];

                    if(nx>=0 && ny>=0 && ny<100 && map[nx][ny] == 1) {
                        x = nx;
                        y = ny;
                        map[x-dx[i]][y-dy[i]] = 2;
                        break;
                    }
                }
            }
            System.out.println("#"+tc+" "+y);
        }
    }
}

