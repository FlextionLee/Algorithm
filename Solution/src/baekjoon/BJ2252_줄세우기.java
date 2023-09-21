package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2252_줄세우기 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //차수 저장
        int[] indegree = new int[n+1];
        //연결 정보
        ArrayList<Integer>[] list = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            indegree[y]++;
        }
        //위상 정렬
        Queue<Integer> q = new ArrayDeque<>();
        //차수가 0일때 큐에 넣는다. 자신을 가르키고 있는 화살표의 갯수
        for(int i=1; i<=n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            System.out.println(q.peek());
            int cur = q.poll();

            for(int i=0; i<list[cur].size(); i++){
                int next = list[cur].get(i);
                indegree[next]--;
                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }
    }
}
