package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ17143_낚시왕 {
    static int R,C,M,ans;
    static class Shark{
        int x;
        int y;
        int dis;
        int speed;
        int size;
        public Shark(int x,int y,int dis,int speed,int size){
            this.x=x;
            this.y=y;
            this.dis =dis;
            this.speed = speed;
            this.size = size;
        }
    }
    //d == 0위  1아래 2오른 3왼
    static int dx[] = {0,0,0,1,-1};
    static int dy[] = {0,1,-1,0,0,};
    static Shark map[][];
    static ArrayList<Shark> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R+1][C+1];
        list = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[r][c] = new Shark(r,c,s,d,z);
            list.add(map[r][c]);
        }
        ans = 0;
        getShark();
        //System.out.println(ans);
    }

    private static void getShark() {

        for(int i=1; i<=1; i++){
            //상어잡기
            for(int j=1; j<=R; j++){
                if(map[j][i] != null){
                    ans += map[j][i].size;

                    //리스트에도 지우기
                    for(int k=0; k< list.size(); k++){
                        if(list.get(k).equals(map[j][i])){
                            list.remove(list.get(k));
                            break;
                        }
                    }
                    // 맵에도 지우기
                    map[j][i] = null;
                    break;
                }
            }

            //d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미
            //상어 움직임
            for(int j=0; j< list.size(); j++){
                Shark tmp = list.get(j);
                int speed = tmp.speed;
                int dis = tmp.dis;
                int x = tmp.x;
                int y = tmp.y;

                if(dis == 1){
                    if((x+speed)/R %2 == 0){

                    }
                    else{

                    }
                }
                else if(dis ==2){

                }
                else if(dis == 3){

                }
                else{

                }


            }
//            for(int j=1; j<=R; j++){
//                for(int z=1; z<=C; z++){
//                    if(map[j][z]!=null) {
//                        System.out.print(map[j][z].size + " ");
//                    }
//                    else{
//                        System.out.print("null ");
//                    }
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
    }
}
