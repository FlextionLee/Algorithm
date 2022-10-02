package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 1번은 2가지 경우
 * 2번은 1가지 경우
 * 3번은 8가지 경우
 * 4번은 4가지
 * 5번은 4가지
 *
 * 해당 칸에 맞는 형식으로 들어갈 수 있는지? 전부 다 넣어본다.
 */

public class BJ14500_테트로미노 {
    static int N,M;
    static int map[][];
    static int[][][] BLOCKS = {
            {{0,0}, {0,1}, {0,2}, {0,3}}
            ,{{0,0}, {1,0}, {2,0}, {3,0}}
            ,{{0,0}, {1,0}, {0,1}, {1,1}}
            ,{{0,0}, {0,1}, {0,2}, {1,2}}
            ,{{0,0}, {1,0}, {2,0}, {0,1}}
            ,{{0,0}, {1,0}, {1,1}, {1,2}}
            ,{{2,0}, {0,1}, {1,1}, {2,1}}
            ,{{1,0}, {1,1}, {1,2}, {0,2}}
            ,{{0,0}, {0,1}, {1,1}, {2,1}}
            ,{{0,0}, {1,0}, {0,1}, {0,2}}
            ,{{0,0}, {1,0}, {2,0}, {2,1}}
            ,{{0,0}, {1,0}, {2,0}, {1,1}}
            ,{{1,0}, {0,1}, {1,1}, {1,2}}
            ,{{0,1}, {1,0}, {1,1}, {2,1}}
            ,{{0,0}, {0,1}, {0,2}, {1,1}}
            ,{{0,0}, {0,1}, {1,1}, {1,2}}
            ,{{0,1}, {1,1}, {1,0}, {2,0}}
            ,{{1,0}, {1,1}, {0,1}, {0,2}}
            ,{{0,0}, {1,0}, {1,1}, {2,1}}
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] arr = new int[n][m];
        int max = 0;
        for(int i=0; i<n; i++){
            for (int j=0;  j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<BLOCKS.length; i++){
            int[][] block = BLOCKS[i];
            for(int j=0; j<n; j++){
                middleLoop :
                for(int k=0; k<m; k++){
                    int sum = 0;
                    for(int l=0; l<4; l++){
                        if(j+block[l][0]>=n || k+block[l][1]>=m){
                             continue middleLoop;
                        }else{
                            sum += arr[j+block[l][0]][k+block[l][1]];
                        }
                    }
                    if(sum > max) max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
