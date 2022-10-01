package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15684_사다리조작 {
    //가로,세로,M,ans
    static int C, M, R;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1];
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //가로선의 시작점
            map[a][b] = 1;
            //가로선의 도착점
            map[a][b + 1] = -1;
        }
        for(int i=0; i<=3; i++){
            boolean result = simul(1,1,i,i);
            if(result){
                return;
            }
        }
    }

    private static boolean simul(int x, int y, int toChoose, int count) {
        if(toChoose == 0){
            if(check()){
                System.out.println(count);
                return true;
            }
            return false;
        }

        for(int i = x; i<=R; i++){
            for(int j=y; j<C; j++){
                if(map[i][j]==0 && map[i][j+1]==0){
                    map[i][j] = 1;
                    map[i][j] = -1;

                    if(simul(i,j+2,toChoose-1,count)){
                        return true;
                    }
                    map[i][j]=0;
                    map[i][j+1]=0;
                }
            }
            y = 1;
        }
        return false;
    }

    private static boolean check() {
        for(int c=1; c<=C; c++){
            int nc = c;
            for(int r=1 ;r<=R; r++){
                if(map[r][nc]==1){
                    nc++;
                }
                else if(map[r][nc]==-1){
                    nc--;
                }
            }
            if(c != nc){
                return false;
            }
        }
        return true;
    }


    //싹수가 노란 녀석은 버리기
    //사이 공간에 가로선이 현재 홀수라면 짝수를 맞춰줘야함 모든 홀수인 구간을 다 찾아보고 이게 3이상이라면 어짜피 안됨


    //0~3개 까지 가로선을 추가하며 게임이 끝나는지 살펴보자

    //아직 안끝났다면?


    //가지치기 조건 만약 성공했다면 끝내버리기


    // row 하나 체크 완료
    //row가 변경되면 col은 1부터 시작
    //최초의 시작은 비어있는 곳부터였지만 다음은 1부터 시작해야함 건너뒤면 안됨


    //모든 컬럼에서 출발했을때 도착지가 출발점의 세로선과 일치하는지 반환


    //이동하고 있는 컬럼의 좌표

    //1이면 오른쪽으로 , -1이면 왼쪽으로

    //만약 시작점과 끝났을때 값이 다르다면 다음 컬럼은 볼 필요도 없으니 리턴
}