package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class BJ1655_가운데를말해요 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int val = Integer.parseInt(br.readLine());
            if(i%2 == 1){
                min.add(val);
            }else{
                max.add(val);
            }

            if(!min.isEmpty() && !max.isEmpty() && max.peek() > min.peek()){
                min.add(max.poll());
                max.add(min.poll());
            }
            sb.append(max.peek()).append("\n");
        }
        System.out.println(sb);

    }
}
