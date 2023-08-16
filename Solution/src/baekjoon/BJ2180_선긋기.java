package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ2180_선긋기 {
    static class Line{
        int x,y;
        public Line(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static ArrayList<Line> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list,(o1,o2)->{
            if(o1.x == o2.x){
                return o1.y - o2.y;
            }else{
                return o1.x - o2.x;
            }
        });
        int sum = 0;
        int prev = Integer.MIN_VALUE;
        for(Line l : list){
            int diff = l.y - l.x;
            if(l.y <= prev){
                continue;
            }
            if(prev > l.x){
                diff  = l.y - prev;
            }
            sum+=diff;
            prev = l.y;
        }
        System.out.println(sum);
    }
}
