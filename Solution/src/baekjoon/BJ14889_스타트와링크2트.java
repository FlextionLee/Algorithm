package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14889_스타트와링크2트 {
    static int N,answer=Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] target;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        target = new boolean[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0,0);
        System.out.println(answer);
    }

    private static void comb(int depth,int start) {
        if(depth == N/2){

            check();
            //complete
        }

        for(int i=start; i<N; i++){
            target[i] = true;
            comb(depth+1,i+1);
            target[i] = false;
        }
    }

    private static void check() {
        int a = 0;
        int b = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(target[i]==true && target[j]==true){
                    a+= map[i][j];
                }
                if(target[i]==false && target[j]==false){
                    b+= map[i][j];
                }
            }
        }

        int abs = Math.abs(a-b);
        answer = Math.min(abs, answer);
    }
}
