package swea;

import java.util.*;
import java.io.*;

public class SWEA_헌터 {

        /*
            1. 맵을 입력받고 좌표를 담는 배열에 추가한다.
            1-1 이 배열을 순열로 돌린다.최대 4쌍이고 8개순열이라 ㅆ가능
            1-2 이 순열이 위상정렬 되어 있는지 체크한다.
            1-3 되어 있다면 사냥꾼의 좌표를 0으로 놓고
                각 좌표들의 값을 계산한다.
            1-4 계산한 값들의 최소값을 갱신한다.
         */

    static class Point{
        int x;int y; int id;
        public Point(int x,int y,int id){
            this.x = x;
            this.y=y;
            this.id=id;
        }
    }

    static int T,N,pair,min;
    static int[][] map;
    static boolean[] visited;
    static ArrayList<Point> points;
    static Point[] target;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T= Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            min =Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            points = new ArrayList<>();
            pair = 0;

            for(int i=0; i<N ;i++){
                StringTokenizer st= new StringTokenizer(br.readLine());
                for(int j=0; j<N;j++){
                    map[i][j]=Integer.parseInt(st.nextToken());
                    // 0이 아니라면 사냥꾼이건 몬스터건 둘중 하나
                    if(map[i][j] != 0){
                        points.add(new Point(i,j,map[i][j]));
                        pair++;
                    }
                }
            }

            visited = new boolean[pair];
            target = new Point[pair];
            // 순열 구하기
            perm(0);
            System.out.println("#"+t+" "+min);
        }
    }

    private static void perm(int depth) {
        if(depth == points.size()){
            //complete code
            if(isSorted()){
                getMin();
            }
            return;
        }

        for(int i=0; i<points.size(); i++){
            if(visited[i]) continue;

            target[depth] = new Point(points.get(i).x,points.get(i).y,points.get(i).id);
            visited[i] = true;
            perm(depth+1);
            visited[i] = false;
        }
    }

    //최소거리 구하기
    private static void getMin() {
        int sum = Math.abs(0-target[0].x) + Math.abs(0-target[0].y);

        for(int i=0; i<points.size()-1; i++){
            sum += Math.abs(target[i].x - target[i+1].x) + Math.abs(target[i].y - target[i+1].y);
        }

        min = Math.min(min,sum);
    }

    //위상정렬 되어있는지 확인
    private static boolean isSorted() {
        int count = 0;
        for(int i=0; i<points.size(); i++){
            if(target[i].id > 0){
                for(int j=i+1; j<target.length; j++){
                    if(target[i].id * -1 == target[j].id){
                        count++;
                    }
                }
            }
        }

        if(count != points.size()/2){
            return false;
        }
        return true;
    }
}
























