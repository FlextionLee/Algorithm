package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW5215_햄버거_다이어트 {
    static class ham{
        int cal;
        int sco;
        public ham(int sco, int cal){
            this.cal = cal;
            this.sco = sco;
        }

    }
    static int T,N,limit;
    static ham[] hams;
    static int max= Integer.MIN_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());
            hams = new ham[N];
            visited = new boolean[N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                hams[i] = new ham(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }


            dfs(0);
            System.out.println(max);
        }
    }
    private static void dfs(int depth) {
        if(depth == N){
            check();
            return;
        }

        visited[depth] = true;
        dfs(depth+1);
        visited[depth] = false;
        dfs(depth+1);
    }

    private static void check() {
        int sumS = 0;
        int sumC = 0;

        for(int i=0; i<N; i++){
            if(visited[i]){
                sumS += hams[i].sco;
                sumC += hams[i].cal;
            }
        }

        if(sumC<=limit){
            max = Math.max(max,sumS);
        }
    }
}

