package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1525_퍼즐 {
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[3][3];
        int sx=0;
        int sy=0;
        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    sx = i;
                    sy = j;
                }
            }
        }

        System.out.println(bfs(sx,sy));
    }
    public static int bfs(int sx,int sy){
        Queue<Node> q = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>();
        String s = "";
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                s+=map[i][j];
            }
        }
        set.add(s);
        q.add(new Node(sx,sy,0,s));

        while(!q.isEmpty()){
            Node tmp = q.poll();
            if(tmp.str.equals("123456780")){
                return tmp.time;
            }

            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(nx<0||ny<0||nx>=3||ny>=3) continue;
                int cur = tmp.x*3+tmp.y;
                int next = nx*3+ny;
                char[] ch = tmp.str.toCharArray();
                char c = ch[cur];
                ch[cur] = ch[next];
                ch[next] = c;
                if(!set.contains(String.valueOf(ch))){
                    set.add(String.valueOf(ch));
                    q.add(new Node(nx,ny,tmp.time+1,String.valueOf(ch)));
                }
            }
        }
        return -1;
    }
    static class Node{
        int x;
        int y;
        int time;
        String str;
        public Node(int x, int y, int time, String str){
            this.x = x;
            this.y = y;
            this.time = time;
            this.str = str;
        }
    }
}
