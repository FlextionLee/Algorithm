package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2623_음악프로그램 {
    static ArrayList<Integer>[] list;
    static int[] indegree;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        indegree = new int[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            for(int j=0; j<k-1; j++){
                int a = Integer.parseInt(st.nextToken());
                indegree[a]++;
                list[idx].add(a);
                idx = a;
            }
        }

        ArrayList<Integer> ansList = topology(n);
        for(int i=1; i<=n; i++){
            if(indegree[i]!=0){
                System.out.println(0);
                return;
            }
        }
        for(int i : ansList){
            System.out.println(i);
        }
    }

    private static ArrayList<Integer> topology(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while(!q.isEmpty()){
            int tmp = q.poll();
            ret.add(tmp);
            for(int i : list[tmp]){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }

        return ret;
    }
}
