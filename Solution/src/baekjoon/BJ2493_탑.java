package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493_탑 {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<int[]> stack = new ArrayDeque<>();

        for(int i=1; i<=N; i++){
            int height = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()) {
                if (stack.peek()[0] >= height) {
                    sb.append(stack.peek()[1]).append(" ");
                    break;
                }
                stack.pop();
            }
           if(stack.isEmpty()){
               sb.append("0 ");
           }
           stack.push(new int[] {height,i});
        }
        System.out.println(sb.toString());
    }
}
