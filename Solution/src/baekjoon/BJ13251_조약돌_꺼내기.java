package baekjoon;

import java.util.*;
import java.io.*;

public class BJ13251_조약돌_꺼내기 {
    static int M,N,K;
    static double ans;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        arr = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            N += arr[i];
            //총 경우의 수 구하기
        }

        K = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            comb(i);
            //조합 구하기
        }

        System.out.println(ans >= 1 ? 1 : ans);
    }
    private static void comb(int depth) {
        if(arr[depth] >= K){
            int a = N;
            int b = K;
            // k개 만큼 뽑음
            double tmp = 1;
            // 누적곱 이기때문에 1로 초기화
            while(b-- > 0){
                tmp *= (arr[depth]-- / (double) a--);
                //뽑는 횟수가 줄어들면서 조약돌 하나를 뽑고 전제갯수에서 하나씩 빠진 값을
                //누적해서 곱해준다.
            }
            //하나의 반복이 끝나고 나온 확률을 더해준다.
            ans += tmp;
        }
        return;
    }
}
