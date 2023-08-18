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
            //햄버거면 큐에 넣는다.
            if(str.charAt(i)=='H'){
                q.add(i);
            //사람이면
            }else{
                boolean ch = true;
                //큐가 빌때까지 탐색 만약 먹을수 있는 값이라면 먹는다.
                while(!q.isEmpty()){
                    if(i-q.peek() <= m){
                        System.out.println(q.peek()+" p="+i);
                        q.poll();
                        count++;
                        ch = false;
                        break;
                    }else{
                        q.poll();
                    }
                }
                //이전에 나왔던 햄버거로는 충족을 못한다면
                if(ch){
                    for(int j=i+1; j<i+m; j++){
                        if(j>=str.length()) break;
                        if(str.charAt(j) == 'P'){
                            i=j;
                        }
                        if(str.charAt(j)=='H'){
                            System.out.println(j+" p="+i);
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
