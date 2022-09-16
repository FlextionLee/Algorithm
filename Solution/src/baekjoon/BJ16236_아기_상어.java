package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ16236_아기_상어 {
    static int N,sx,sy,sSize=2;
    static int ans, eatcount;
    static int map[][];
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};

    static class Fish implements Comparable<Fish>{
        int x;
        int y;
        int size;
        int dis;
        public Fish(int x,int y,int size, int dis) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.dis = dis;
        }
        @Override
        public int compareTo(Fish o) {
            if(this.dis == o.dis) {
                if(this.x == o.x) {
                    return Integer.compare(this.y, o.y);
                }
                else {
                    return Integer.compare(this.x, o.x);
                }
            }
            else {
                return Integer.compare(this.dis, o.dis);
            }
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    sx = i;
                    sy = j;
                }
            }
        }

        bfs(sx,sy);
        System.out.println(ans);
    }
    private static void bfs(int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {sx,sy,0});
        boolean visited[][] = new boolean[N][N];
        visited[sx][sy] = true;
        PriorityQueue<Fish> pq = new PriorityQueue<>();
        int fish = -1;

        re:
        while(!q.isEmpty()) {
            int[] tmp = q.poll();

            for(int k=0; k<4; k++) {
                int nx = tmp[0]+dx[k];
                int ny = tmp[1]+dy[k];

                if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny]) continue;

                visited[nx][ny] = true;

                if(map[nx][ny]==0 || map[nx][ny] == sSize){
                    q.add(new int[]{nx,ny,tmp[2]+1});
                }

                else if(map[nx][ny] < sSize) {
                    if(fish==-1 || fish == tmp[2]+1){
                        pq.offer(new Fish(nx,ny,map[nx][ny],tmp[2]+1));
                        fish = tmp[2]+1;
                    }
                    else{
                        break re;
                    }
                }
            }
        }
        if(pq.isEmpty()){
            return;
        }
        else{
            Fish f = pq.poll();

            ans += f.dis;
            System.out.println(f.dis+" "+map[f.x][f.y]);
            map[f.x][f.y]= 0;
            eatcount++;
            if(eatcount == sSize){
                sSize++;
                eatcount=0;
            }
            sx = f.x;
            sy = f.y;
            bfs(sx,sy);
        }
    }

}