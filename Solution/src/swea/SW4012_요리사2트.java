package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW4012_요리사2트 {
    /**
     * 두 명의 손님에게 음식 제공
     * 식성이 비슷하기 때문에 최대한 비슷한 맛의 음식을 만들어야함
     *
     * N개의 식재료로 N/2개씩 나누어 2개의 요리를 함
     * 이때 A음식 과 B음식의 맛의 차이가 최소가 되도록 재료를 배분하자
     *
     * N개중에 N/2를 고르는 부분집합을 생성한다
     * true인놈들 한팀 false인놈들 한팀 완탐으로 모든 조합들에 대해서 최소값을 구하면 됨
     * */
    static int T, N,ans;
    static int map[][];
    static boolean[] target;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            ans = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            target = new boolean[N];
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 입력 끝
            // 부분집합 생성 하기
            subSet(0,0);
            System.out.println("#"+t+" "+ans);

        }
    }

    private static void subSet(int depth,int start) {
        if(depth == N/2){
            getSynerge();
            return;
        }

        for(int i=start; i<N; i++){
            target[i] = true;
            subSet(depth+1,i+1);
            target[i] = false;
        }
    }

    private static void getSynerge() {
        int[] a = new int[N/2];
        int[] b = new int[N/2];
        int ai =0;
        int bi =0;
        for(int i=0; i<N; i++){
            if(target[i]){
                a[ai++] = i;
            }
            else{
                b[bi++] = i;
            }
        }

        int asum=0;
        int bsum=0;
        for(int i=0; i<N/2; i++){
            for(int j=i+1; j<N/2; j++){
                asum += map[a[i]][a[j]] + map[a[j]][a[i]];
                bsum += map[b[i]][b[j]] + map[b[j]][b[i]];
            }
        }

        int abs = Math.abs(asum-bsum);
        ans = Math.min(abs,ans);
    }
}
