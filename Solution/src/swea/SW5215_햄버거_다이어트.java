package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW5215_햄버거_다이어트 {
    static class Hamburger{
        int taste;
        int calory;
        public Hamburger(int taste, int calory) {
            this.taste = taste;
            this.calory = calory;
        }
    }
    static int T,N,M,TASTE,CALORY;
    static Hamburger[] hams;
    static boolean isSelected[];
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            MAX = Integer.MIN_VALUE;
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            hams = new Hamburger[N];
            isSelected = new boolean[N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                hams[i] = new Hamburger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            dfs(0);
            sb.append("#").append(t).append(" ").append(MAX);
            System.out.println(sb.toString());
        }
    }
    private static void dfs(int index) {
        if(index == N) {
            int cal = 0;
            int tas = 0;
            for (int i = 0; i < N; i++) {
                if(isSelected[i]) {
                    cal += hams[i].calory;
                    tas += hams[i].taste;
                }
            }
            if(cal >= M) {
                return;
            }
            else {
                MAX = Math.max(MAX, tas);
            }
            return;
        }
        isSelected[index] = true;
        dfs(index+1);
        isSelected[index] = false;
        dfs(index+1);
    }

}

