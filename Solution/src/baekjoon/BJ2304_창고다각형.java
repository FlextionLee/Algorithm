package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ2304_창고다각형 {
    static class Bar{
        int width;
        int height;
        public Bar(int width, int height){
            this.width = width;
            this.height = height;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Bar> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Bar(a,b));
        }
        Collections.sort(list,(o1, o2)->{
            return o1.width - o2.width;
        });
        int max = 0;
        int maxIdx = 0;
        for(int i=0; i<list.size(); i++){
            if(max < list.get(i).height){
                max = list.get(i).height;
                maxIdx = i;
            }
        }

        //현재 가장 큰 막대는 크기가 같다면 마지막 막대이다.
        int h = 0;
        int sum = 0;
        int prev = 0;
        int pos = 0;
        for(int i=0; i<=maxIdx; i++){
            if(h < list.get(i).height){
                sum += (list.get(i).width - list.get(prev).width) * h;
                h = list.get(i).height;
                prev = i;
                pos = i;
            }
        }
        h = 0;
        prev = list.size()-1;
        for(int i=list.size()-1; i>=maxIdx; i--){
            if(h < list.get(i).height){
                sum += (list.get(prev).width - list.get(i).width) * h;
                h = list.get(i).height;
                prev = i;
            }
        }
        sum += (list.get(prev).width - list.get(pos).width + 1) * max;
        System.out.println(sum);
    }
}
