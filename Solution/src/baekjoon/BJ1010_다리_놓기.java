package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1010_다리_놓기{

    static int T,N,M;
    static StringTokenizer st;
    static int paskal[][] = new int[31][31];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        makePaskal();
        T = Integer.parseInt(br.readLine());
        for(int i=1; i<=T; i++) {
            st= new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            System.out.println(paskal[M][N]);
        }
    }
    private static void makePaskal() {
        paskal[0][0] = 1;
        paskal[1][0] = 1;
        paskal[1][1] = 1;

        for(int i=2; i<=30; i++) {
            for(int j=0; j<=i; j++) {
                if(j-1 < 0) {
                    paskal[i][j] = 1;
                    continue;
                }
                paskal[i][j] = paskal[i-1][j-1] + paskal[i-1][j];
            }
        }

    }
}