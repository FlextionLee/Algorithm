package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2475_검증수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum =0;
        for(int i=0; i<5; i++){
            sum += (int)Math.pow(Double.parseDouble(st.nextToken()),2);
        }
        System.out.println(sum %=10);

    }
}
