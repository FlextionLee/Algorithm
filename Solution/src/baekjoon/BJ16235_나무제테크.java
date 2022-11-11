package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ16235_나무제테크 {
    static int N,M,K;
    static class Tree implements Comparable<Tree>{
        int x,y,age;
        boolean isAlive=true;
        public Tree(int x, int y, int age){
            this.x=x;
            this.y=y;
            this.age=age;
        }
        @Override
        public int compareTo(Tree o) {
            return this.age-o.age;
        }
    }
    static List<Tree> list;
    static List<Tree> list2;
    static int add[][];
    static int map[][];
    static int tmpMap[][];
    static int dx[] = {0,0,-1,1,1,1,-1,-1};
    static int dy[] = {-1,1,0,0,-1,1,1,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        add = new int[N+1][N+1];
        map = new int[N+1][N+1];
        tmpMap = new int[N+1][N+1];
        list = new ArrayList<>();
        list2 = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                add[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
                tmpMap[i][j] =0;
            }
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Tree(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }
        for(int i=0; i<K; i++) {
            if(i%2==0){
                simul();
            }
            else{
                simulHol();
            }
        }
        System.out.println(list.size()+list2.size());
    }
    private static void simul() {
        Collections.sort(list);
        Tree tmp = null;
        //봄
        for(int i=0; i<list.size(); i++){
           //뽑아
            tmp = list.get(i);
            int x = tmp.x;
            int y = tmp.y;
            //맵이 나를 감당 할 수 있다?
            if(map[x][y]-tmp.age >= 0) {
                map[x][y] -= tmp.age;
                tmp.age++;
                list2.add(tmp);
                if(tmp.age%5==0) {

                    for(int j=0; j<8; j++) {
                        int nx = x+dx[j];
                        int ny = y+dy[j];

                        if(nx<1||ny<1||nx>N||ny>N) continue;
                        list2.add(new Tree(nx,ny,1));
                    }
                }
            }
            //맵이 나를 감당못해
            else {
                tmp.isAlive = false;
                tmpMap[tmp.x][tmp.y] += tmp.age/2;
            }
        }

        //겨울
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                map[i][j] += tmpMap[i][j]+add[i][j];
                tmpMap[i][j] = 0;
            }
        }
        list.clear();
    }

    private static void simulHol() {
        Collections.sort(list2);
        Tree tmp = null;
        //봄
        for(int i=0; i<list2.size(); i++){
            tmp = list2.get(i);
            int x = tmp.x;
            int y = tmp.y;
            if(map[x][y]-tmp.age >= 0) {
                map[x][y] -= tmp.age;
                tmp.age++;
                list.add(tmp);
                if(tmp.age%5==0) {

                    for(int j=0; j<8; j++) {
                        int nx = x+dx[j];
                        int ny = y+dy[j];

                        if(nx<1||ny<1||nx>N||ny>N) continue;
                        list.add(new Tree(nx,ny,1));
                    }
                }
            }
            else {
                tmp.isAlive = false;
                tmpMap[tmp.x][tmp.y] += tmp.age/2;
            }
        }

        //겨울
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                map[i][j] += tmpMap[i][j]+add[i][j];
                tmpMap[i][j] = 0;
            }
        }
        list2.clear();
    }
}