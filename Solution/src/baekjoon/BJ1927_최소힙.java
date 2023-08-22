package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;
import java.util.PriorityQueue;

public class BJ1927_최소힙 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int m = Integer.parseInt(br.readLine());
            if(m == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll());
                }
            }else{
                pq.add(m);
            }
        }

    }
}
