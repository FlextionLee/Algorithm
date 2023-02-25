package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1247_최적경로 {
    static int T,N,ans;
    static class Node{
        int x,y;
        public Node(int x, int y){
            this.x= x;
            this.y=y;
        }
    }
    static Node[] nodes;
    static Node company;
    static Node house;
    static boolean[] visited;
    static int[] target;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            ans = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            nodes = new Node[N];
            visited = new boolean[N];
            target = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            company = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            house = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            for(int i=0; i<N; i++){
                nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            perm(0);
            System.out.println("#"+t+" "+ans);
        }
    }

    private static void perm(int depth) {
        if(depth == N){
            getDis();
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i]){
                target[depth] = i;
                visited[i] = true;
                perm(depth+1);
                visited[i] =false;
            }
        }
    }

    private static void getDis() {
        int dis =0 ;
        int tx = nodes[target[0]].x;
        int ty = nodes[target[0]].y;

        dis = Math.abs(company.x-tx) + Math.abs(company.y-ty);

        for(int i=1; i<N; i++){
            int idx = target[i];
            dis += Math.abs(nodes[idx].x-tx)+Math.abs(nodes[idx].y-ty);
            tx = nodes[idx].x;
            ty = nodes[idx].y;
        }

        dis += Math.abs(tx- house.x) + Math.abs(ty- house.y);
        ans = Math.min(dis,ans);
    }
}
