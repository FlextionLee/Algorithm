package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ9205_맥주마시면서걸어가기 {
    static int T,N,homex,homey,fesx,fesy;
    static String answer;
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static Node[] nodes;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            homex = Integer.parseInt(st.nextToken());
            homey = Integer.parseInt(st.nextToken());
            nodes = new Node[N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                nodes[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            fesx = Integer.parseInt(st.nextToken());
            fesy = Integer.parseInt(st.nextToken());
            answer = "sad";
            bfs();
            System.out.println(answer);
        }
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        q.add(new int[] {homex,homey});

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int tx = tmp[0];
            int ty = tmp[1];
            if(Math.abs(tx-fesx) + Math.abs(ty-fesy) <= 1000){
                answer = "happy";
                return;
            }
            for(int i=0; i<N; i++){
                if(!visited[i]){
                    int nx = nodes[i].x;
                    int ny = nodes[i].y;
                    int dis = Math.abs(tx-nx)+Math.abs(ty-ny);
                    if(dis<=1000){
                        visited[i] = true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}
