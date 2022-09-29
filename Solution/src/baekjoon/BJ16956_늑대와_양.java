package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16956_늑대와_양 {
    static int N,M;
    static char[][] map;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for(int i=0; i<N; i++){
            char[] tmp = br.readLine().toCharArray();
            map[i]= tmp;
        }
        int answer = 1;

        Loop:
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] =='W'){
                    for(int k=0; k<4; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];

                        if(nx<0||ny<0||nx>=N||ny>=M) continue;
                        if(map[nx][ny] == 'S'){
                            answer =0;
                            break Loop;
                        }
                        else if(map[nx][ny] == '.'){
                            map[nx][ny] = 'D';
                        }
                    }
                }
            }
        }

        System.out.println(answer);
        if(answer == 1) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }

    }
}
