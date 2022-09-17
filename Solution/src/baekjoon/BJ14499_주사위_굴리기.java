package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14499_주사위_굴리기 {
    static int N,M,X,Y,K;
    static int map[][];
    static int dice[][];
    static int[][] dimap ={
            {},
            {1,1},
            {0,1},
            {1,2},
            {1,0},
            {2,1},
            {3,1},
    };
    static int top = 1;
    static int bottom = 6;
    static int right = 3;
    static int left = 4;
    static int front = 5;
    static int back = 2;
    static int dx[] = {0,0,0,-1,1};
    static int dy[] = {0,1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dice = new int[4][3];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
           int command = Integer.parseInt(st.nextToken());

           int nx = X+dx[command];
           int ny = Y+dy[command];

           if(nx<0||ny<0||nx>=N||ny>=M) continue;

            X = nx;
            Y = ny;
            if(command == 1){
                int tmp = top;
                top = left;
                left = bottom;
                bottom = right;
                right = tmp;
            }
            else if(command == 2){
                int tmp = top;
                top = right;
                right = bottom;
                bottom = left ;
                left = tmp;
            }
            else if(command == 3){
                int tmp = top;
                top = front;
                front = bottom;
                bottom = back;
                back = tmp;
            }
            else if( command == 4){
                int tmp = top;
                top = back;
                back = bottom;
                bottom = front;
                front = tmp;
            }

            if(map[nx][ny] == 0){
                map[nx][ny] = dice[dimap[bottom][0]][dimap[bottom][1]];
            }
            else{
                dice[dimap[bottom][0]][dimap[bottom][1]] = map[nx][ny];
                map[nx][ny]=0;
            }
            System.out.println(dice[dimap[top][0]][dimap[top][1]]);
            //씨발 풀었다.
        }
    }
}
