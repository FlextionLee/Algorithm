package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ10845_큐 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int val = 0;
            if(st.hasMoreTokens()){
                val = Integer.parseInt(st.nextToken());
            }
            
            switch(cmd){
                case "push":
                    q.add(val);
                    break;
                case "pop":
                    if(q.isEmpty()) System.out.println(-1);
                    else System.out.println(q.poll());
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if(q.isEmpty()) System.out.println("1");
                    else System.out.println("0");
                    break;
                case "front":
                    if(q.isEmpty()) System.out.println("-1");
                    else System.out.println(q.peek());
                    break;
                case "back":
                    if(q.isEmpty()) System.out.println("-1");
                    else System.out.println(q.peekLast());
                    break;
            }
        }
    }
}
