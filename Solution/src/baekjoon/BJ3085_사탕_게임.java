package baekjoon;

import java.util.*;
import java.io.*;

public class BJ3085_사탕_게임 {

    static int N;
    static int result = Integer.MIN_VALUE;
    static void calculate(char[][] b) {

        // 행 비교하여 가장 긴 연속 부분을 찾아 사탕을 먹는다
        for(int i = 0 ; i < N; i++) {
            int sum1 = 1;
            for(int j = 0 ; j < N-1; j++) {
                if(b[i][j] == b[i][j+1]) {
                    sum1++;
                } else {
                    sum1 = 1;
                }
                result = Math.max(result, sum1);
            }
        }

        // 열 비교하여 가장 긴 연속 부분을 찾아 사탕을 먹는다
        // 다른 방법으로 열을 비교해봤다.
        int j = 0;
        while(true) {
            int sum2 = 1;
            for(int i = 0 ; i < b.length-1; i++) {
                if(b[i][j] == b[i+1][j]) {
                    sum2++;
                } else {
                    sum2 = 1;
                }
                result = Math.max(result, sum2);
            }

            if(j == b.length-1) {
                break;
            }
            j++;
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String a = "";

        char[][] b = new char[N][N];
        for(int i = 0 ; i < N; i ++) {
            a = br.readLine();
            for(int j = 0 ; j < N; j ++) {
                b[i][j] = a.charAt(j);
            }
        }

        // 아무것도 교환하지 않았을때
        calculate(b);

        // 행 비교
        for(int i = 0 ; i < N; i++) {
            for(int j = 0 ; j < N-1; j++) {
                if(b[i][j] != b[i][j+1]) {
                    // 스왑
                    char temp = b[i][j];
                    b[i][j] = b[i][j + 1];
                    b[i][j + 1] = temp;

                    calculate(b);

                    // 원래대로
                    temp = b[i][j];
                    b[i][j] = b[i][j + 1];
                    b[i][j + 1] = temp;
                }
            }
        }

        // 열 비교
        for(int i = 0 ; i < N; i++) {
            for(int j = 0 ; j < N-1; j++) {
                if(b[j][i] != b[j+1][i]) {
                    // 스왑
                    char temp = b[j][i];
                    b[j][i] = b[j + 1][i];
                    b[j + 1][i] = temp;

                    calculate(b);

                    // 원래대로
                    temp = b[j][i];
                    b[j][i] = b[j + 1][i];
                    b[j + 1][i] = temp;
                }
            }
        }


        System.out.print(result);

    }


}
