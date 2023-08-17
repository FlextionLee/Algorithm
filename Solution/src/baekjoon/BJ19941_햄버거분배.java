package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ19941_햄버거분배 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        Queue<Integer> q = new ArrayDeque<>();
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='H'){
                q.add(i);
            }else{
                boolean ch = true;
                while(!q.isEmpty()){
                    if(i-q.peek() <= m){
                        q.poll();
                        count++;
                        ch = false;
                        break;
                    }else{
                        q.poll();
                    }
                }

                if(ch){
                    for(int j=i; j<=i+m; j++){
                        if(j>=str.length()) break;
                        if(str.charAt(j)=='H'){
                            //System.out.println(j+" p="+i);
                            count++;
                            i = j;
                            break;
                        }
                    }
                }

            }
        }
        System.out.println(count);
    }
}
