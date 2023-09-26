package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ13460_구슬탈출2 {
    static int N,M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int rx,ry,bx,by,hx,hy,ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R'){
                    rx = i;
                    ry = j;
                    map[i][j] = '.';
                }else if(map[i][j] == 'B'){
                    bx = i;
                    by = j;
                    map[i][j] = '.';
                }else if(map[i][j] == 'O'){
                    hx = i;
                    hy = j;
                }
            }
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[N][M][N][M];
        q.add(new int[]{rx,ry,bx,by,0});
        visited[rx][ry][bx][by] = true;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            //System.out.println(tmp[0]+" "+tmp[1]+" "+tmp[2]+" "+tmp[3]);
            if(tmp[4] == 10){
                return -1;
            }
            for(int i=0; i<4; i++){
                int[] redMove = move(tmp[0],tmp[1],i);
                int[] blueMove = move(tmp[2],tmp[3],i);
                //파란공이 구멍에 들어갔을 경우
                if(blueMove.length == 4){
                    continue;
                }
                //빨간 공이 구멍에 들어갔을 경우
                if(redMove.length == 4){
                    return tmp[4]+1;
                }
                //둘의 같은 위치를 가르킬때
                if(redMove[0] == blueMove[0] && redMove[1] == blueMove[1]){
                    if(redMove[2] < blueMove[2]){
                        blueMove[0] -= dx[i];
                        blueMove[1] -= dy[i];
                    }else{
                        redMove[0] -= dx[i];
                        redMove[1] -= dy[i];
                    }
                }
                if(!visited[redMove[0]][redMove[1]][blueMove[0]][blueMove[1]]){
                    visited[redMove[0]][redMove[1]][blueMove[0]][blueMove[1]] = true;
                    q.add(new int[]{redMove[0],redMove[1],blueMove[0],blueMove[1],tmp[4]+1});
                }
            }
        }
        return -1;
    }
    public static int[] move(int nx,int ny,int dir){
        int count = 0;
        int tx = nx;
        int ty = ny;
        boolean ch = false;
        while(true){
            if(tx<0||ty<0||tx>=N||ty>=M||map[tx][ty]=='#'){
                tx -= dx[dir];
                ty -= dy[dir];
                count--;
                break;
            }
            tx += dx[dir];
            ty += dy[dir];
            count++;
            if(tx == hx && ty == hy) ch = true;
        }
        if(ch){
            return new int[]{tx,ty,count,1};
        }else {
            return new int[]{tx, ty, count};
        }
    }
}
