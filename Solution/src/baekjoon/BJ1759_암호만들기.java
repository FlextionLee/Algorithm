package baekjoon;
import java.util.*;
import java.io.*;
public class BJ1759_암호만들기 {
    static int N,M;
    static char alp[];
    static char target[];
    static int check[] = {1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        alp = new char[M];
        target = new char[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            alp[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alp);

        comb(0,0);
        System.out.println(sb);
    }

    private static void comb(int depth,int start) {
        if(depth == N) {
            if(isPossible()) {
                sb.append(String.valueOf(target)).append("\n");
            }
            return;
        }

        if(start == M){
            return;
        }
        target[depth] = alp[start];
        comb(depth+1,start+1);
        comb(depth,start+1);
    }

    private static boolean isPossible() {
        int mo=0;
        int ja=0;
        for(int i=0; i<N; i++){
            if(check[target[i]-97] != 0){
                mo++;
            }
            else{
                ja++;
            }
        }
        if(mo >= 1 && ja>=2){
            return true;
        }
        return false;
    }
}
