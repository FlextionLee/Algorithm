package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW4013_특이한자석 {
    /**
     * 각 자석은 8개의 날을 가지고 있음 날마다 N, S  극이있다.
     * 각 자석은 4개
     * 입력으로 1번 자식부터니까 -1 한값으로 받고 1, -1 (시계 반시계임)
     */


    static int gears[][];
    static boolean visited[];
    static ArrayList<int[]> list;
    static int T,K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            K = Integer.parseInt(br.readLine());

            gears = new int[4][8];

            for(int i=0; i<4; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<8; j++){
                    gears[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int tGear = Integer.parseInt(st.nextToken()) - 1;
                int dis = Integer.parseInt(st.nextToken());
                list = new ArrayList<>();
                visited = new boolean[4];

                list.add(new int[]{tGear, dis});
                visited[tGear] = true;
                check(tGear, dis);

                //움직이자!
                rotate();
            }

            //계산하자
            System.out.println("#"+t+" "+calc());
        }
    }

    private static int calc() {
        int ans = 0;
        for(int i=0; i<4; i++){
            if(gears[i][0] == 1){
                ans += Math.pow(2,i);
            }
        }
        return ans;
    }

    private static void rotate() {
        for(int i=0; i<list.size(); i++){
            int target = list.get(i)[0];
            int dis = list.get(i)[1];

            if(dis == 1){
                int tmp = gears[target][7];
                for(int j=7; j>0; j--){
                    gears[target][j] = gears[target][j-1];
                }
                gears[target][0] = tmp;
            }
            else {
                int tmp = gears[target][0];
                for (int j = 0; j < 7; j++) {
                    gears[target][j] = gears[target][j + 1];
                }
                gears[target][7] = tmp;
            }
        }
    }

    //움직여야하는 기어들을 찾자
    private static void check(int tGear, int dis) {
        if(tGear==0){
            if(gears[0][2] != gears[1][6] && !visited[1]){
                list.add(new int[]{1,dis*-1});
                visited[1] = true;
                check(1,dis*-1  );
            }
        }
        if(tGear==1){
            if(gears[1][6] != gears[0][2] && !visited[0]){
                list.add(new int[] {0,dis*-1});
                visited[0] = true;
                check(0,dis*-1);
            }
            if(gears[1][2] != gears[2][6] && !visited[2]){
                list.add(new int[] {2,dis*-1});
                visited[2] = true;
                check(2,dis*-1);
            }
        }
        if(tGear==2){
            if(gears[2][6] != gears[1][2] && !visited[1]){
                list.add(new int[] {1,dis*-1});
                visited[1] = true;
                check(1,dis*-1);
            }
            if(gears[2][2] != gears[3][6] && !visited[3]){
                list.add(new int[] {3,dis*-1});
                visited[3] = true;
                check(3,dis*-1);
            }
        }
        if(tGear==3){
            if(gears[3][6] != gears[2][2] && !visited[2]){
                list.add(new int[]{2,dis*-1});
                visited[2] = true;
                check(2,dis*-1  );
            }
        }
    }
}
