package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ9019_DSLR {
    static int N;
    static int a,b;
    static boolean[] visited ;
    static String[] answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int t=1; t<=N; t++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            String[] answer = new String[10000];
            boolean[] visited = new boolean[10000];

            bfs();
        }
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(a);
        visited[a] = true;

        while(!q.isEmpty()){
            int tmp = q.poll();

            if(tmp == b){
                return;
            }

            int d = tmp*2%10000;
            int s = (tmp==0)?9999:tmp-1;
            int l = (tmp % 1000) * 10 + tmp/1000;
            int r = (tmp % 10) * 1000 + tmp/10;
        }

    }

}
