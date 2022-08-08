package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ17298_오큰수 {
    static int N;
    static int[] arr;
    static ArrayDeque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }

        for(int i: arr){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());

    }
}
