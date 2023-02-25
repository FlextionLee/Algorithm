package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW4008_숫자만들기 {
    static int T,N,min,max;
    static int[] oper;
    static int[] number;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            number = new int[N];
            oper = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++){
                oper[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                number[i] = Integer.parseInt(st.nextToken());
            }
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            dfs(1,number[0]);
            System.out.println("#"+t+" "+(max-min));
        }
    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            min = Math.min(min, sum);
            max = Math.max(max,sum);
            return;
        }

        for(int i=0; i<4; i++){
            if(oper[i] > 0){
                if(i==0){
                    oper[i]--;
                    dfs(depth+1,sum + number[depth]);
                    oper[i]++;
                }
                else if(i==1){
                    oper[i]--;
                    dfs(depth+1,sum - number[depth]);
                    oper[i]++;
                }
                else if(i==2){
                    oper[i]--;
                    dfs(depth+1,sum * number[depth]);
                    oper[i]++;
                }
                else{
                    oper[i]--;
                    dfs(depth+1,sum / number[depth]);
                    oper[i]++;
                }
            }
        }
    }
}
