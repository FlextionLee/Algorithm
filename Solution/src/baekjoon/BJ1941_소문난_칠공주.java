package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BJ1941_소문난_칠공주 {
    static int count = 0;
    static char[][] map = new char[5][5];
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<int[]> tgt = new ArrayList<>();
    static boolean[][] tmpMap;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<25; i++){
            list.add(new int[] {i/5,i%5});
        }
        comb(0,0,0);
        System.out.println(count);
    }

    private static void comb(int depth, int start,int som) {
        if(depth == 7){
            if(som>=4){
                if(bfs()){
                    count++;
                }
            }
            return;
        }

        if(7-depth+som<4){
            return;
        }

        for(int i=start; i<list.size(); i++){
            int[] tmp = list.get(i);
            tgt.add(new int[]{tmp[0],tmp[1]});
            if(map[tmp[0]][tmp[1]]=='S'){
                comb(depth+1,i+1,som+1);
            }
            else{
                comb(depth+1,i+1,som);
            }
            tgt.remove(tgt.size()-1);
        }
    }

    private static boolean bfs() {
        tmpMap = new boolean[5][5];
        boolean visitMap[][] = new boolean[5][5];

        for(int i=0; i<7; i++){
            int[] tmp = tgt.get(i);
            tmpMap[tmp[0]][tmp[1]] = true;
        }

        Queue<int []> q = new ArrayDeque<>();
        q.add(new int[] {tgt.get(0)[0],tgt.get(0)[1]});
        visitMap[tgt.get(0)[0]][tgt.get(0)[1]] = true;
        int check = 1;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for(int k=0; k<4; k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(nx <0|| nx>=5||ny<0||ny>=5||visitMap[nx][ny]){
                    continue;
                }
                if(tmpMap[nx][ny]){
                    q.add(new int[]{nx, ny});
                    visitMap[nx][ny] = true;
                    check++;
                }
            }
        }
        if(check == 7){
            return true;
        }
        else{
            return false;
        }
    }
}