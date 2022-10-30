package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ21608_상어초등학교 {
    static int N;
    static int map[][];
    static int info[][];
    static int arr[];
    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};
    static class Node{
        int x,y;
        int count, zeroCount;

        public Node(int x, int y, int count, int zeroCount) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.zeroCount = zeroCount;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", count=" + count +
                    ", zeroCount=" + zeroCount +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        info = new int[N*N+1][4];
        arr = new int[N*N];

        for(int i=0; i<N*N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            info[a][0] = b;
            info[a][1] = c;
            info[a][2] = d;
            info[a][3] = e;
            arr[i] = a;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((p1,p2)->{
            if(p1.count ==  p2.count){
                if(p2.zeroCount == p1.zeroCount){
                    if(p2.x == p1.x){
                        return p1.y-p2.y;
                    }
                    else{
                        return p1.x-p2.x;
                    }
                }
                else{
                    return p2.zeroCount - p1.zeroCount;
                }
            }
            else{
                return p2.count-p1.count;
            }
        });

        //학생 순서가 하나씩 나옴
        for(int i=0; i<N*N; i++){
            //학생
            int num = arr[i];
            //빈칸을 하나씩 뽑음
            for(int j=1; j<=N; j++){
                for(int k=1; k<=N; k++){
                    //빈 칸이라면
                    if(map[j][k]==0){
                        //상하좌우 탐색하면서 카운트를 세고 해당 카운트에 맞는 표현리스트에 담음
                        int count =0;
                        int zeroCount = 0;
                        for(int l=0; l<4; l++){
                            int target = info[num][l];
                            for(int z=0; z<4; z++){
                                int nx = j+dx[z];
                                int ny = k+dy[z];

                                if(nx<1||ny<1||nx>N||ny>N) continue;
                                if(map[nx][ny] == target) count++;
                            }
                        }
                        for(int z=0; z<4; z++){
                            int nx = j+dx[z];
                            int ny = k+dy[z];

                            if(nx<1||ny<1||nx>N||ny>N) continue;
                                if(map[nx][ny] == 0) zeroCount++;
                        }
                        pq.add(new Node(j,k,count,zeroCount));
                    }
                }
            }
            Node tmp = pq.poll();
            map[tmp.x][tmp.y] = num;
            pq.clear();
        }

        int ans = 0;

        for(int i=1; i<=N; i++){
            for(int j=0; j<=N; j++){
                int num = map[i][j];
                int count = 0;

                for(int k=0; k<4; k++){
                    int n = info[num][k];

                    for(int l=0; l<4; l++){
                        int nx = i+dx[l];
                        int ny = j+dy[l];

                        if(nx<1||ny<1||nx>N||ny>N) continue;
                        if(map[nx][ny] == n) count++;
                    }
                }
                if(count > 0){
                    ans += Math.pow(10,count-1);
                }
            }
        }

        System.out.println(ans);

    }
}
