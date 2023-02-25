package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW5644_무선충전 {
    static int T,M,A,ans;
    static int[][] map;
    static int[] aTrace;
    static int[] bTrace;
    static int[] dx = {0,-1,0,1,0};
    static int[] dy = {0,0,1,0,-1};
    static class Node{
        int dis;
        int x;
        int y;
        int power;
        int num;
        public Node(int x, int y,int dis,int power,int num){
            this.dis = dis;
            this.x = x;
            this.y = y;
            this.power = power;
            this.num = num;
        }
    }

    static class Person{
        int x;
        int y;
        public Person(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Person a;
    static Person b;

    static Node[] nodes;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            map = new int[10+1][10+1];
            nodes = new Node[A+1];
            aTrace = new int[M];
            bTrace = new int[M];
            a = new Person(1,1);
            b = new Person(10,10);


            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                aTrace[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                bTrace[i] = Integer.parseInt(st.nextToken());
            }


            for(int i=1; i<=A; i++){
             st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int dis = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());

                nodes[i] = new Node(x,y,dis,power,i);
            }

            simul();
            System.out.println("#"+t+" "+(ans));
        }
    }

    private static void simul() {
        getPower();

        for(int i=0; i<M; i++){
            a.x += dx[aTrace[i]];
            a.y += dy[aTrace[i]];
            b.x += dx[bTrace[i]];
            b.y += dy[bTrace[i]];
            getPower();
        }



    }

    /**
     * 현재 내 위치에서 충전 가능한 충전기를 찾기
     * 여러개 갈 수 있다? 그 중 성능좋은거 선택
     * 하나 밖에 못간다. 그냥 선택
     * 현재 누군가 쓰고 있다 ? 반으로 나눔
     * 현재 누군가 쓰고 있지만 다른 선택지가 있다? 반으로 나눈값고 다른선택지를 비교하여 더 큰 값을 선택
     */

    private static void getPower() {
        PriorityQueue<Node> aq = new PriorityQueue<>((x1, x2) -> x2.power - x1.power);
        PriorityQueue<Node> bq = new PriorityQueue<>((x1, x2) -> x2.power - x1.power);

        for (int i = 1; i <= A; i++) {
            int aDis = getDistance(a.x, a.y, nodes[i].x, nodes[i].y);
            int bDis = getDistance(b.x, b.y, nodes[i].x, nodes[i].y);

            if (aDis <= nodes[i].dis) {
                aq.offer(nodes[i]);
            }
            if (bDis <= nodes[i].dis) {
                bq.offer(nodes[i]);
            }
        }
        int power = 0;
        Node ap = aq.poll();
        Node bp = bq.poll();

        if(ap == null && bp==null) power=0;
        else if(ap==null && bp != null) power += bp.power;
        else if(ap!=null && bp == null) power += ap.power;
        else{
            if(ap.num == bp.num){
                power += ap.power;

                Node ap2 = aq.poll();
                Node bp2 = bq.poll();

                if(ap2!=null && bp2 != null){
                    power += Math.max(ap2.power,bp2.power);
                }
                else{
                    power += (ap2 == null ? (bp2 == null ? 0 : bp2.power) : ap2.power);
                }
            }
            else{
                power += (ap.power+bp.power);
            }
        }
        System.out.println(power);
        ans += power;
    }
    private static int getDistance(int x,int y, int dx,int dy){
        return Math.abs(x-dx)+Math.abs(y-dy);
    }
}
