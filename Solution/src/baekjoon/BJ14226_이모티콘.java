package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ14226_이모티콘 {
    static class Emo{
        int val,clipboard,time;
        public Emo(int val , int clipboard, int time){
            this.val=val;
            this.clipboard = clipboard;
            this.time = time;
        }
    }
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        System.out.println(bfs(n));
    }

    private static int bfs(int n) {
        Queue<Emo> q = new ArrayDeque<>();
        q.add(new Emo(1,0,0));
        boolean[][] visited = new boolean[1001][1001];
        visited[1][0]= true;

        while(!q.isEmpty()){
            Emo e = q.poll();
            int val = e.val;
            int clip = e.clipboard;
            int time = e.time;

            if(val == n){
                return time;
            }

            q.add(new Emo(val,val,time+1));
            visited[val][val] = true;

            if(clip!=0 && val+clip <=n && !visited[val+clip][clip]){
                q.add(new Emo(val+clip,clip,time+1));
                visited[val+clip][clip] = true;
            }

            if(val > 0 && !visited[val-1][clip]){
                q.add(new Emo(val-1,clip,time+1));
                visited[val-1][clip] = true;
            }

        }
        return -1;
    }
}
