package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16236_아기_상어 {
    static public int N,sx,sy,ans,sSize=2,count;
    static public int[][] map;
    static ArrayList<Node> nodes= new ArrayList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true){
            bfs();
            if(nodes.size()==0){
                break;
            }
            Node tmp = nodes.get(0);
            for(int i=1; i<nodes.size(); i++){
                if(tmp.d == nodes.get(i).d){
                    if(tmp.x == nodes.get(i).x){
                        if(tmp.y > nodes.get(i).y){
                            tmp = new Node(nodes.get(i).x,nodes.get(i).y,nodes.get(i).d);
                        }
                    }
                    else if(tmp.d > nodes.get(i).d){
                        tmp = new Node(nodes.get(i).x,nodes.get(i).y,nodes.get(i).d);
                    }
                }
                else if(tmp.d > nodes.get(i).d){
                    tmp = new Node(nodes.get(i).x,nodes.get(i).y,nodes.get(i).d);
                }
            }

            sx = tmp.x;
            sy = tmp.y;
            ans += tmp.d;
            count++;
            map[sx][sy] = 0;
            if(count == sSize){
                sSize++;
                count = 0;
            }
        }
        System.out.println(ans);
    }

    private static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        q.add(new Node(sx,sy,0));

        while(!q.isEmpty()){
            Node tmp = q.poll();
            if(map[tmp.x][tmp.y] != 0 && map[tmp.x][tmp.y] < sSize){
                nodes.add(new Node(tmp.x,tmp.y,tmp.d));
            }

            for(int k=0; k<4; k++){
                int nx = tmp.x+dx[k];
                int ny = tmp.y+dy[k];

                if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny]) continue;
                if(map[nx][ny] < sSize){
                   q.add(new Node(nx,ny,tmp.d+1));
                   visited[nx][ny] =true;
                }
            }
        }
    }

    static class Node{
        int x;
        int y;
        int d;
        public Node(int x, int y, int d){
            this.x=x;
            this.y=y;
            this.d=d;
        }
    }
}
