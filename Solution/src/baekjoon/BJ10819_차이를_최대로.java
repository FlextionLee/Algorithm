package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10819_차이를_최대로 {
    static int N, max= Integer.MIN_VALUE,sum;
    static int[] arr;
    static int[] target;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        target = new int[N];
        visited = new boolean[N];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        perm(0);
        System.out.println(max);
    }

    private static void perm(int depth) {
        if(depth == N){
            max = Math.max(max,getResult());
            return;
        }

        for(int i=0;i<N; i++){
            if(visited[i]){
                continue;
            }

            visited[i] = true;
            target[depth] = arr[i];
            perm(depth+1);
            visited[i] = false;
        }
    }

    private static int getResult() {
        int sum =0;
        for(int i=0; i<N-1; i++){
            sum += Math.abs(target[i] - target[i+1]);
        }
        return sum;
    }
}
