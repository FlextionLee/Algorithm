package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ13913_숨바꼭질4 {
    static class Node{
        int x;
        int count;
        ArrayList<Integer> list;
        public Node(int x, int count, ArrayList<Integer> list){
            this.x = x;
            this.count =count;
            this.list = list;
        }
    }
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        parent = new int[100001];
        int time = bfs(n,k);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);
        System.out.println(time);
        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        while(k != n){
            stack.push(parent[k]);
            k = parent[k];
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
        System.out.println(sb);
    }
    private static int bfs(int n, int k) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{n,0});
        boolean[] visited = new boolean[100001];
        visited[n] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            if(tmp[0] == k){
                return tmp[1];
            }

            int minus =tmp[0]-1;
            int plus = tmp[0] +1;
            int multi = tmp[0] *2;

            if(plus <= 100000 && !visited[plus]){
                visited[plus] = true;
                q.add(new int[]{plus,tmp[1]+1});
                parent[plus] = tmp[0];
            }
            if(minus >= 0 && !visited[minus]){
                visited[minus] = true;
                q.add(new int[]{minus,tmp[1]+1});
                parent[minus] = tmp[0];
            }
            if( multi <= 100000 && !visited[multi]){
                visited[multi] = true;
                q.add(new int[]{multi,tmp[1]+1});
                parent[multi] = tmp[0];
            }
        }
        return -1;
    }
}
