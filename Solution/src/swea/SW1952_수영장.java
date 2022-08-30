package swea;
import java.util.*;
import java.io.*;

/**
 * 가장 적은 비용으로 수영장을 이용할 수 있는 방법
 * 1. 1일 이용권
 * 2. 한달 이용권 (1일부터 시작~
 * 3. 3달 이용권 ( 11, 12, 1 이런식으로 안되고 1~12만 가능)
 * 4. 1년 이용권 (1월 1일부터 ~~
 *
 * 1~12까지 배열에 해당 달에 이용할 날의 수가 주어짐
 * 가장 적은 비용으로 수영장을 이용할 수 있는 방법을 찾자
 *
 *
 */
public class SW1952_수영장 {
    static int T,day,month,three,year,min;
    static int[] plan = new int[12];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            three = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());
            int daydata = 0;
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
                if(plan[i] > 0){
                    daydata += plan[i];
                }
            }

            min = Math.min(year , day*daydata);

            dfs(0,0);
            plan = new int[12];
            System.out.println("#"+t+" "+min);
        }
    }

    private static void dfs(int depth, int sum) {
        if(sum > min){
            return;
        }
        if(depth > 11){
            min = Math.min(sum,min);
            return;
        }

        if(plan[depth] == 0)
            dfs(depth+1, sum);
        else{
            dfs(depth + 1, sum + month);
            dfs(depth + 1, sum + plan[depth] * day);
            dfs(depth + 3, sum + three);
        }
    }
}


