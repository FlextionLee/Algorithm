package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1759_암호_만들기 {
    static int N,M;
    static char[] arr;
    static char[] tmp;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[M];
        tmp  = new char[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        sb = new StringBuilder();
        dfs(0,0);
        System.out.println(sb.toString());
    }


    private static void dfs(int depth,int count) {
        if(depth == N){
            if(isRight()){
                sb.append(String.valueOf(tmp)).append("\n");
            }
            return;
        }

        for(int i=count; i<M; i++){
            tmp[depth] = arr[i];
            dfs(depth+1,count+1);
        }
    }

    private static boolean isRight() {
        int vow =0;
        int con = 0;
        for (char x : tmp) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                vow++;
            } else {
                con++;
            }
        }
        if (vow >= 1 && con >= 2) {
            return true;
        }
        return false;
    }
}
