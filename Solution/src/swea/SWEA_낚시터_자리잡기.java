package swea;

import java.util.*;
import java.io.*;

public class SWEA_낚시터_자리잡기 {

    static class Gate{
        int pos;
        int fisher;

        public Gate(int pos, int fisher){
            this.pos = pos;
            this.fisher = fisher;
        }
    }
    static int T,N,min;
    static Gate[] gates;
    static boolean visited[];
    static int[] target;
    static int[] map;
    static int fisherCnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t =1 ;t<=T; t++){
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            map = new int[N+1];
            visited = new boolean[4];
            gates = new Gate[4];
            target = new int[4];
            for(int i=1; i<4; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                gates[i] = new Gate(a,b);
            }
            perm(0,0);
            System.out.println(min);
        }

    }
    static void perm(int depth, int sum){
        if(depth == 3){
            //complete
            min = Math.min(min,sum);
            return;
        }

        if(sum >= min){
            return;
        }

        for(int i=1; i<=3; i++){
            if(visited[i]) continue;
            visited[i] = true;

            perm(depth+1,sum+inFisher(i,gates[i].fisher, true));
            outFisher(i);

            if(gates[i].fisher %  2 == 0){
                perm(depth+1,sum+inFisher(i,gates[i].fisher, false));
                outFisher(i);
            }
            visited[i] = false;
        }
    }

    private static void outFisher(int idx) {
        int cnt = 0;
        for(int i=1; i<=N; i++){
            if(map[i] == idx){
                map[i] = 0;
                cnt++;
            }
            if(cnt == gates[idx].fisher)return;
        }
    }

    private static int inFisher(int idx, int fisher, boolean flag) {
        int distance = 0;
        fisherCnt = 0;
        int sum = 0;
        
        while(fisherCnt < fisher){
            sum += flag ? left(idx,distance) : right(idx,distance);
            
            if(fisherCnt == fisher) break;

            sum += flag ? right(idx,distance) : left(idx,distance);
            distance++;
        }
        for(int i=0; i<N; i++){
            System.out.print(map[i]+" ");
        }
        System.out.println();
        return sum;
    }

    private static int left(int idx, int distance) {
        int left = gates[idx].pos - distance;

        if(left>0 && map[left] == 0){
            map[left] = idx;
            fisherCnt++;
            return distance + 1;
        }
        return 0;
    }

    private static int right(int idx, int distance) {
        int right = gates[idx].pos + distance;

        if(right<=N && map[right] == 0){
            map[right] = idx;
            fisherCnt++;
            return distance + 1;
        }
        return 0;
    }
}
