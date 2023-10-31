package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1966_프린터큐 {
    static class Job{
        int idx;
        int val;
        public Job(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            LinkedList<Job> q = new LinkedList<>();
            Queue<Job> tmp = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                int v = Integer.parseInt(st.nextToken());
                q.add(new Job(i,v));
            }

            int count = 0;

            while(!q.isEmpty()){
                Job j = q.poll();
                boolean isMax = true;

                for(int i=0; i<q.size(); i++){
                    if(j.val < q.get(i).val){
                        q.add(j);
                        for(int k=0; k<i; k++){
                            q.add(q.poll());
                        }
                        isMax = false;
                        break;
                    }
                }

                if(!isMax) continue;
                count++;
                if(m == j.idx){
                    break;
                }
            }
            System.out.println(count);
        }
    }
}
