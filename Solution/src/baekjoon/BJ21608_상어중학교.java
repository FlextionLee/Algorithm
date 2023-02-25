package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class BJ21608_상어중학교 {
    static int N;
    static ArrayList[] list;
    static int[][] visited;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static class Node{
        int x,y,count;

        public Node(int i, int j, int count) {
            this.x=i;
            this.y=j;
            this.count=count;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N*N+1];

        for(int i=0; i<N*N+1; i++){
            list[i]= new ArrayList();
        }

        visited = new int[N*N+1][N*N+1];
        Queue<Integer> q = new ArrayDeque<>();

        for(int i=1; i<=N*N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[i].add(b);
            list[i].add(c);
            list[i].add(d);
            list[i].add(e);
            q.add(a);
        }

        PriorityQueue<Node> candi = new PriorityQueue<>((a1,a2)->a2.count-a1.count);

        while(!q.isEmpty()){
            int num = q.poll();

            for(int i=0; i<visited.length; i++){
                for(int j=0; j<visited.length; j++){
                    if(visited[i][j] == 0){
                        int count = 0;
                        for(int k=0; k<4; k++){
                            int nx = i+dx[k];
                            int ny = j+dy[k];

                            if(nx<0||ny<0||nx>N*N||ny>N*N)continue;
                            for(int l=0; l<4; l++){
                                if(visited[nx][ny] == (int)list[num].get(l)) count++;
                            }
                            candi.add(new Node(i,j,count));
                        }
                    }
                }
            }

            if(candi.size() == 1){
                Node tmp = candi.poll();
                visited[tmp.x][tmp.y] = num;
                candi.clear();
            }
            //후보가 많다면?
            else if(candi.size() > 1){
                PriorityQueue<Node> pq = new PriorityQueue<>((p1,p2)->p2.count-p1.count);
                while(!candi.isEmpty()){
                    Node tmp = candi.poll();
                    int count = 0;
                    for(int i=0; i<4; i++){
                        int nx = tmp.x+dx[i];
                        int ny = tmp.y+dy[i];

                        if(nx<0||ny<0||nx>N*N||ny>N*N) continue;

                        if(visited[nx][ny]==0) count++;
                    }
                    pq.add(new Node(tmp.x,tmp.y,count));
                }
            }
        }
    }
}
