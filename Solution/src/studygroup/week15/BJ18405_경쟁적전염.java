package studygroup.week15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ18405_경쟁적전염 {
    static int N,K,S;
    static int[][] map;
    static int tx,ty;
    static class Node implements Comparable<Node>{
        int val,x,y,t;
        public Node(int x, int y, int val,int t) {
            this.x = x;
            this.y = y;
            this.val = val;
            this.t=t;
        }
        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
        @Override
        public String toString() {
            return "Node [val=" + val + ", x=" + x + ", y=" + y + ", t=" + t + "]";
        }
    }
    static List<Node> list;
    static Queue<Node> q;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        list = new ArrayList<>();

        for(int i=1; i<=N; i++	) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) {
                    list.add(new Node(i,j,map[i][j],0));
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        tx = Integer.parseInt(st.nextToken());
        ty = Integer.parseInt(st.nextToken());


        Collections.sort(list);
        q = new ArrayDeque<>();

        for(Node n : list){
            q.add(n);
        }

        bfs();
        System.out.println(map[tx][ty]);
    }
    private static void bfs() {
        while(!q.isEmpty()) {
            Node tmp = q.poll();
            if(tmp.t == S) {
                return;
            }
            for(int i=0; i<4; i++) {
                int nx =tmp.x + dx[i];
                int ny = tmp.y +dy[i];
                int time = tmp.t+1;

                if(nx<1||ny<1||nx>N||ny>N||map[nx][ny]!=0) continue;
                map[nx][ny] = tmp.val;
                q.add(new Node(nx,ny,tmp.val,time));
            }
        }
    }
}
