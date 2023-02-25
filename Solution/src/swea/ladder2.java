package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;

public class ladder2 {
    static int[][] map;
    static int min,ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t=1 ; t<=10; t++){
            br.readLine();
            map = new int[100][100];
            min = Integer.MAX_VALUE;
            for(int i=0; i<100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    map[i][j]= Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<100; i++){

                int count = 0;

                if(map[0][i] == 1){

                    int x = 0;
                    int y = i;
                    while(x < 100){
                        if(y-1 >= 0 && map[x][y-1] == 1){
                            while(y-1 >= 0 && map[x][y-1] == 1) {
                                count++;
                                y--;
                            }
                        }
                        else if(y+1 < 100 && map[x][y+1] == 1){
                            while(y+1 < 100 && map[x][y+1] == 1){
                                count++;
                                y++;
                            }
                        }
                        x++;
                        count++;
                    }
                    if(count <= min){
                        ans = i;
                        min = count;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}