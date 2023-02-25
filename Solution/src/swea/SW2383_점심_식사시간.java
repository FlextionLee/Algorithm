package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 일단 부분집합 으로 풀어야하고
 * 사람 클래스 (로우 컬럼 이동시간)
 */
class SW2383_점심_식시시간{
    static int T,N,ans;
    static int[][] map;
    static boolean[] visited;
    static Stair[] stairs;

    static class Person{
        int x;
        int y;
        int time;
        public Person(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static class Stair{
        int x;
        int y;
        int dis;
        public Stair(int x, int y,int dis){
            this.x=x;
            this.y=y;
            this.dis=dis;
        }
    }

    static ArrayList<Person> list;
    public static void main(String[] args) throws Exception{
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            list = new ArrayList<>();
            stairs = new Stair[2];
            int si = 0;

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]==1){
                        list.add(new Person(i,j));
                    }
                    else if(map[i][j] > 1){
                        stairs[si++] = new Stair(i,j,map[i][j]);
                    }
                }
            }
            visited = new boolean[list.size()];
            ans = Integer.MAX_VALUE;
            subSet(0);
            System.out.println("#"+t+" "+ans);
        }
    }

    private static void subSet(int depth) {
        if(depth==list.size()){
            //complete
            simul();
            return;
        }
        visited[depth] = true;
        subSet(depth+1);
        visited[depth] = false;
        subSet(depth+1);
    }

    private static void simul() {
        PriorityQueue<Person> aq = new PriorityQueue<>((p1,p2) -> p1.time-p2.time);
        PriorityQueue<Person> bq = new PriorityQueue<>((p1,p2) -> p1.time-p2.time);

        for(int i=0; i<visited.length; i++){
            if(visited[i]){
                Person p = list.get(i);
                p.time = Math.abs(p.x - stairs[0].x) + Math.abs(p.y-stairs[0].y) + 1;
                aq.add(p);
            }
            else{
                Person p = list.get(i);
                p.time = Math.abs(p.x - stairs[1].x) + Math.abs(p.y-stairs[1].y) + 1;
                bq.add(p);
            }
        }

        int aqTime = getAqtime(aq);
        int bqTime = getBqtime(bq);
        int time = (aqTime>bqTime)?aqTime:bqTime;

        ans = Math.min(ans,time);
        }

    private static int getBqtime(PriorityQueue<Person> bq) {
        int time[] = new int[1000];
        int end = 0;
        while(!bq.isEmpty()){
            Person tmp = bq.poll();
            int start = tmp.time;
            end = tmp.time+stairs[1].dis;

            for(int i=start; i<end; i++){
                if(time[i]==3){
                    end++;
                    continue;
                }
                time[i]++;
            }
        }
        return end;
    }

    private static int getAqtime(PriorityQueue<Person> aq) {
        int time[] = new int[1000];
        int end = 0;
        while(!aq.isEmpty()){
            Person tmp = aq.poll();
            int start = tmp.time;
            end = tmp.time+stairs[0].dis;

            for(int i=start; i<end; i++){
                if(time[i]==3){
                    end++;
                    continue;
                }
                time[i]++;
            }
        }
        return end;
    }
}