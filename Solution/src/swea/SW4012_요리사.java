package swea;

/*두 명의 손님에게 음식을 제공하려 함
식성이 비슷하기 때문에 비슷한 맛의 음식을 만들어야함
식재로들을 N/2 개씩 나누어 두개의 요리를 하려고함
a음식 b음식의 맛의 차이가 최소가 되도록 해야함 */
import java.util.*;
import java.io.*;
public class SW4012_요리사 {
    static int T,N;
    static int[][] map;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visit = new boolean[N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            comb(0,0);
            System.out.println("#"+t+" "+min);
            min = Integer.MAX_VALUE;
        }
    }

    private static void comb(int depth, int start) {
        if(depth == N/2){
            check();
            return;
        }
            if(start == N){
                return;
            }
            visit[start] = true;
            comb(depth+1,start+1);
            visit[start] = false;
            comb(depth,start+1);
    }

    private static void check() {
        int[] a = new int[N/2];
        int[] b = new int[N/2];
        int ai = 0;
        int bi = 0;
        for(int i=0; i<N; i++){
            if(visit[i]){
                a[ai++] = i;
            }
            else{
                b[bi++] = i;
            }
        }
        int suma=0;
        int sumb=0;

        for(int i=0; i<N/2; i++){
            for(int j=0; j<N/2; j++){
                if(i==j){
                    continue;
                }
                suma += map[a[i]][a[j]];
                sumb += map[b[i]][b[j]];
            }
        }
        int abs = Math.abs(suma-sumb);
        min = Math.min(abs,min);
    }

}
