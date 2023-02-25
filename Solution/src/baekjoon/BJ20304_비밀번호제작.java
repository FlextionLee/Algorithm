package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ20304_비밀번호제작 {
    static int N,M,ans=Integer.MIN_VALUE;
    static int pw[];
    static int candi[];
    static Queue<Integer> q;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        pw = new int[N+1];
        Arrays.fill(pw, -1);

        q = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++){
            int tmp = Integer.parseInt(st.nextToken());
            pw[tmp] = 0;
            q.offer(tmp);
        }
        bfs();
        System.out.println(ans);
    }

    private static void bfs() {

        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i=0; i<20; i++){
                int nx = tmp^(1<<i);
                if(nx>N||pw[nx] != -1) continue;

                pw[nx] = pw[tmp]+1;
                q.offer(nx);
                ans = Math.max(ans,pw[nx]);
                System.out.println(ans);
            }
        }
    }
}
