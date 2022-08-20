package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class Bj9663_NQueen {
    static int cnt = 0;
    static int N;
    //여왕이 있는 자리를 나타내는 배열
    //안에 들어가 있는 수는 column이고 각 자리는 row를 의미
    static int[] queen;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        queen = new int[N];

        dfs(0);

        System.out.println(cnt);
    }

    static void dfs(int depth){
        if(depth == N){
            cnt++;
            return;
        }

        for(int i = 0; i<N; i++){
            queen[depth] = i;

            if(canPut(depth))
                dfs(depth+1);
        }
    }

    //여왕이 자리에 들어갈 수 있는지를 판단하는 함수
    static boolean canPut(int depth){
        for(int i = 0; i<depth; i++){
            if(queen[depth] == queen[i])
                return false;
                //row의 차이와 column의 차이가 같다면 대각선에 있다.
            else if(Math.abs(depth-i) == Math.abs(queen[depth] - queen[i]))
                return false;
        }
        return true;
    }
}