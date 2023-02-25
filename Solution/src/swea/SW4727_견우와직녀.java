package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SW4727_견우와직녀 {
    static int T,N,M,ans;
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static class Node{
        int x,y,time,chance;
        public Node(int x, int y,int time){
            this.x=x;
            this.y=y;
            this.time= time;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", time=" + time +
                    '}';
        }
    }
    static ArrayList<Node> list;
    static boolean[][] visited;
    static PriorityQueue<Node> q = new PriorityQueue<>((p1,p2)->p1.time-p2.time);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            list = new ArrayList<>();

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    int count = 0;
                    if(map[i][j] == 0){
                        for(int k=0; k<4; k++){
                            int nx = i+dx[k];
                            int ny = j+dy[k];
                            if(nx<0||ny<0||nx>=N||ny>=N) continue;
                            if(map[nx][ny] > 1 || map[nx][ny] == 0) count++;
                        }
                        if(count < 3){
                            list.add(new Node(i,j,1));
                        }
                    }
                }
            }

            ans = Integer.MAX_VALUE;


            for(Node n : list){
                visited = new boolean[N][N];
                q.clear();
                map[n.x][n.y] = M;
                bfs(0,0);
                map[n.x][n.y] -= M;
            }

            System.out.println("#"+t+" "+ans);
        }

    }

    private static void bfs(int x, int y) {
        //PriorityQueue<Node> q = new PriorityQueue<>((p1,p2)->p1.time-p2.time);
        q.add(new Node(x,y,0));
        visited[x][y] =true;

        while(!q.isEmpty()){
            Node tmp = q.poll();

            if(tmp.x == N-1 && tmp.y == N-1) {
                ans = Math.min(ans,tmp.time);
                return;
            }

            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];

                if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny]) continue;

                if(map[nx][ny] == 1){
                    q.add(new Node(nx,ny,tmp.time+1));
                    visited[nx][ny] =true;
                }
                else if(map[nx][ny] > 1){
                    if(map[x][y] == 1){
                        if(map[nx][ny] >= tmp.time +1){
                            q.add(new Node(nx,ny,map[nx][ny]));
                            visited[nx][ny] =true;
                        }
                        else{
                            int wait =0;
                            int k =1;
                            while(true){
                                wait = map[nx][ny]*k;
                                k++;
                                if(wait >= tmp.time+1){
                                    q.add(new Node(nx,ny,wait));
                                    visited[nx][ny] =true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
