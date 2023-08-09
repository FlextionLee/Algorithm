package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;

public class BJ20125_쿠키의신체측정 {
    static char[][] map;
    static int dx[] = {0,0,1,1,1};
    static int dy[] = {-1,1,0,-1,1};
    static int[] base;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        base = new int[2];
        int[] heart = new int[2];
        for(int i=0; i<n; i++){
            String s= br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] =s.charAt(j);
                if(base[0] == 0 && base[1] ==0 && map[i][j] == '*'){
                    base[0] = i+1;
                    base[1] = j;
                    heart[0] = base[0];
                    heart[1] = base[1];
                }
            }
        }

        int lh = getLength(0);
        int rh = getLength(1);
        int waist = getLength(2);
        int ll = getLength(3);
        int rl = getLength(4);
        System.out.println((heart[0]+1)+" "+(heart[1]+1));
        System.out.println(lh+" "+rh+" "+waist+" "+ll+" "+rl);
    }

    private static int getLength(int i) {
        int nx = base[0];
        int ny = base[1];
        int count = 0;
        nx += dx[i];
        ny += dy[i];
        while(true){
            if(nx<0||ny<0||nx>=map.length||ny>= map.length||map[nx][ny]=='_') break;
            if(i==2){
                base[0] = nx;
                base[1] = ny;
            }
            if(i >= 3){
                nx += dx[2];
                ny += dy[2];
            }else{
                nx += dx[i];
                ny += dy[i];
            }
            count++;
        }
        return count;
    }
}
