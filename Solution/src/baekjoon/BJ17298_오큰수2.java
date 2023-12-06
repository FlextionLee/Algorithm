package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ17298_오큰수2 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            while(!s.isEmpty() && arr[s.peek()] < arr[i]){
                arr[s.pop()] = arr[i];
            }
            s.push(i);
        }

        while(!s.isEmpty()){
            arr[s.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i).append(" ");
        }
        System.out.println(sb);

    }
}
