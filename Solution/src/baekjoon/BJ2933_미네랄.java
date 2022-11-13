package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2933_미네랄 {
    static int R,C,N;
    static char[][] map;
    static int[] mineral;
    static boolean visited[][];
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};

    static class Cluster implements Comparable<Cluster>{
        int x , y;
        public Cluster(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(Cluster o) {
            if(this.x == o.x){
                return this.y-o.y;
            }
            else{
                return this.x-o.x;
            }
        }
    }
    static ArrayList<Cluster> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map= new char[R][C];
        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
        }
        N = Integer.parseInt(br.readLine());
        mineral = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            mineral[i] = Integer.parseInt(st.nextToken());
        }

        simul();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void simul() {
        //던지는 인덱스
        for(int i=0; i<N; i++){
            int t = mineral[i];

            //던지기
            if(i%2==0){
                crack(R-t,0);
            }
            else{
                crack(R-t,1);
            }

            //바닥에 붙어있는 클러스터 방문체크
            visited = new boolean[R][C];
            list = new ArrayList<>();
            for(int j=0; j<C; j++){
                if(map[R-1][j]=='x'){
                    bfs(R-1,j,0);
                    break;
                }
            }

            //위에서 부터 방문체크 안된놈이있다면?
            loop:
            for(int k=0; k<R; k++){
                for(int j=0; j<C; j++){
                    if(map[k][j] == 'x' && !visited[k][j]){
                        bfs(k,j,1);
                        break loop;
                    }
                }
            }

            if(list.size() > 0){
                int count =0;
                loop:
                for(int j=1; j<R; j++){
                    for(int k=0; k<list.size(); k++){
                        if(list.get(k).x+j > R-1 || map[list.get(k).x+j][list.get(k).y] == 'x'){
                            break loop;
                        }
                    }
                    count++;
                }

                for(int k=0; k<list.size(); k++){
                    int x = list.get(k).x;
                    int y = list.get(k).y;
                    map[x+count][y] = 'x';
                }
            }

        }
    }


    private static void bfs(int i, int j, int status) {
        if(status == 0){
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{i,j});
            visited[i][j] = true;

            while(!q.isEmpty()){
                int tmp[] = q.poll();
                for(int k=0; k<4; k++){
                    int nx = tmp[0]+dx[k];
                    int ny = tmp[1]+dy[k];
                    if(nx<0||ny<0||nx>=R||ny>=C||visited[nx][ny]) continue;
                    if(map[nx][ny]=='x'){
                        q.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        else{
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{i,j});
            list.add(new Cluster(i,j));
            visited[i][j] = true;
            map[i][j] = '.';

            while(!q.isEmpty()){
                int tmp[] = q.poll();
                list.add(new Cluster(tmp[0],tmp[1]));
                for(int k=0; k<4; k++){
                    int nx = tmp[0]+dx[k];
                    int ny = tmp[1]+dy[k];
                    if(nx<0||ny<0||nx>=R||ny>=C||visited[nx][ny]) continue;
                    if(map[nx][ny]=='x'){
                        q.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                        map[nx][ny] = '.';
                    }
                }
            }
        }

    }

    private static void crack(int t,int state) {

        if(state == 0) {
            for (int i = 0; i < C; i++) {
                if (map[t][i] == 'x') {
                    map[t][i] = '.';
                    return;
                }
            }
        }
        else{
            for (int i = C-1; i >= 0; i--) {
                if (map[t][i] == 'x') {
                    map[t][i] = '.';
                    return;
                }
            }
        }
    }
}
