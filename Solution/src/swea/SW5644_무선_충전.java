package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SW5644_무선_충전 {
    static int T,M,A;
    static int[] traceA;
    static int[] traceB;
    static ArrayList<Integer>[][] map;
    static Charger[] chargers;
    static int dx[] = {0,-1,0,1,0};
    static int dy[] = {0,0,1,0,-1};

    static class Charger{
        int x;
        int y;
        int cov;
        int per;
        public Charger(int x,int y,int cov,int per){
            this.x=x;
            this.y=y;
            this.cov=cov;
            this.per=per;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            traceA = new int[M+1];
            traceB = new int[M+1];
            map = new ArrayList[11][11];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                traceA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                traceB[i] = Integer.parseInt(st.nextToken());
            }

            chargers = new Charger[A];


            for(int i=0; i<A; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int cov = Integer.parseInt(st.nextToken());
                int per = Integer.parseInt(st.nextToken());
                chargers[i] = new Charger(x,y,cov,per);
                bfs(x,y,cov,per);
            }

            int sumA =0;
            int sumB =0;

            if(map[1][1] != null){
                sumA = map[1][1].get(0);
            }
            else{
                sumA = 0;
            }
            if(map[10][10] != null){
                sumB = map[10][10].get(0);
            }
            else{
                sumB = 0;
            }

            int ax = 1;
            int ay = 1;
            int bx = 10;
            int by = 10;

            for(int i=0; i<M; i++){
                ax += + dx[traceA[i]];
                ay += dy[traceA[i]];
                bx += dx[traceB[i]];
                by += dy[traceB[i]];

                if(map[ax][ay] == null){
                    sumA += 0;
                }
                if(map[bx][by] == null){
                    sumB += 0;
                }
                if(map[ax][ay]!=null && map[bx][by] != null){
                    if(map[ax][ay].get(0) == map[bx][by].get(0)){
                        if(map[ax][ay].size() > 1 && map[bx][by].size() > 1) {
                            sumA += map[ax][ay].get(0);
                            sumB += map[bx][by].get(1);
                        }
                        if(map[ax][ay].size() > 1 && map[bx][by].size() == 1) {
                            sumB += map[bx][by].get(0);
                            int tmp = map[bx][by].get(0);

                            for (int j = 0; j < map[ax][ay].size(); j++) {
                                if (map[ax][ay].get(j) != tmp) {
                                    sumA += map[ax][ay].get(j);
                                    break;
                                }
                            }
                        }
                        if(map[bx][by].size() > 1 && map[ax][ay].size() == 1){
                            sumA += map[ax][ay].get(0);
                            int tmp = map[ax][ay].get(0);

                            for(int j=0; j<map[bx][by].size(); j++){
                                if(map[bx][by].get(j) != tmp){
                                    sumB += map[bx][by].get(j);
                                    break;
                                }
                            }
                        }
                        else {
                            sumA += map[ax][ay].get(0) / 2;
                            sumB += map[bx][by].get(0) / 2;
                        }
                    }
                    else{
                        sumA += map[ax][ay].get(0);
                        sumB += map[bx][by].get(0);
                    }
                }

            }
            System.out.println(sumA);
            System.out.println(sumB);
        }
    }

    private static void bfs(int x,int y,int cov, int per) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x,y,0});
        map[x][y] = new ArrayList<>();
        map[x][y].add(per);
        int count = 1;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int i = tmp[0];
            int j = tmp[1];
            if(tmp[2] == cov){
                break;
            }

            for(int k=1; k<5; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if (nx < 0 || ny < 0 || nx > 10 || ny > 10) {
                    continue;
                }
                if (map[nx][ny] == null) {
                    map[nx][ny] = new ArrayList<>();
                    map[nx][ny].add(per);
                } else {
                    if(!map[nx][ny].contains(per)){
                        map[nx][ny].add(per);
                        Collections.sort(map[nx][ny], Collections.reverseOrder());
                    }
                }
                q.add(new int[]{nx, ny, tmp[2]+1});
            }
        }
    }
}
