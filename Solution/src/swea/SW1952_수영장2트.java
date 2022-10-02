package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1952_수영장2트 {
    /**
     * 수영장 이용 정액이 여러가지있음
     * 어떻게 이용해야 최저가로 이용할 수 있을까?
     */
    static int T,day,month,three,year,ans;
    static int[] plan;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            three = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());
            plan = new int[12];
            ans = year;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0,0);

            System.out.println("#"+t+" "+ans);
        }
    }

    private static void dfs(int depth,int sum) {

        if(depth > 11){
            ans = Math.min(sum,ans);
            return;
        }

        if(sum > ans){
            return;
        }
        if(plan[depth] != 0) {
            dfs(depth + 1, sum + (day * plan[depth]));
            dfs(depth + 1, sum + month);
            dfs(depth + 3, sum + three);
        }
        else{
            dfs(depth+1,sum);
        }
    }
}
