package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ18869_멀티버스2 {
    public static void main(String[] args) throws Exception {
        int M, N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[][] list = new int[M][N];
        int[][] subList = new int[M][N];
        int[][] value = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
                subList[i][j] = list[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            Arrays.sort(subList[i]);
        }
        StringBuilder[] sb = new StringBuilder[M];
        for (int i = 0; i < M; i++) {
            sb[i] = new StringBuilder();
            for (int j = 0; j < N; j++) {
                sb[i].append(Arrays.binarySearch(subList[i], list[i][j]));
            }
        }
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<M; i++){
            set.add(sb[i].toString());
        }
        System.out.println(M - set.size());
    }
}
