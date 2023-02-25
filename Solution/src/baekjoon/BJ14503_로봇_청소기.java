package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14503_로봇_청소기 {

    static class Robot{
        int x;
        int y;
        int dis;
        int ans=0;
        public Robot(int x,int y,int dis){
            this.x=x;
            this.y=y;
            this.dis=dis;
        }
    }
    static Robot robot;
    static int N,M;
    static int map[][];
    static boolean visited[][];
    static int[][] dxy = {
        {0,-1},
        {-1,0},
        {0,1},
        {1,0}
    };
    //상 - 좌
    //우 - 상
    //하 - 우
    //좌 - 하
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());

        robot = new Robot(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulation();
        System.out.println(robot.ans);

    }

    private static void simulation() {
        /**
         * 1.현재위치를 청소한다.
         *  2. 현재위치에서 현재방향을 기준으로 왼쪽방향부터 차례대로 탐색
         *      왼쪽 방향에 청소공간 있으면 회전 후 이동 -> 1.
         *      청소공간 없으면 회전 -> 2.
         *      모두 탐색했지만 이미 벽이거나 청소구역이고 현재방향에 뒤쪽방향으로 갈 수 있는 경우 후진 -> 2.
         *       모두 탐색했지만 이미 벽이거나 청소구역이고 현재방향에 뒤쪽방향으로 갈 수 없는 경우 -> 작동 멈춤
         */
        boolean check = true;
        while(check){
            map[robot.x][robot.y] = 2;


            for(int i=0; i<4; i++){
                int nx = robot.x+dxy[robot.dis][0];
                int ny = robot.x+dxy[robot.dis][1];

                if(nx<0||ny<0||nx>=N||ny>=M) {
                    robot.dis++;
                    robot.dis = robot.dis%4;
                    continue;
                }
                if(map[nx][ny] == 0){
                    robot.x = nx;
                    robot.y = ny;
                    robot.dis++;
                    map[nx][ny]=2;
                    robot.ans++;
                    robot.dis = robot.dis%4;
                    break;
                }
                else if(map[nx][ny] == 1 || map[nx][ny] == 2){
                    robot.dis++;
                    robot.dis = robot.dis%4;
                    continue;
                }

                if(i==3){
                    int rx = robot.x+dxy[(robot.dis+2)%4][0];
                    int ry = robot.y+dxy[(robot.dis+2)%4][1];
                    if(rx<0||ry<0||rx>=N||rx>=M||map[rx][ry]==1){
                        check = false;
                        break;
                    }
                    else if(map[rx][ry]==2){
                        robot.x = rx;
                        robot.y = ry;
                        break;
                    }
                }

            }
        }

    }
}
