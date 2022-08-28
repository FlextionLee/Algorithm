package swea;

import java.util.*;
import java.io.*;

public class SWEA_Shuffle_O_Matic {
    static int T,N,min;
    static int[] cards;
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
            cards = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                cards[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0,cards);
            if(min == Integer.MAX_VALUE){
                System.out.println("#"+t+" -1");
            }
            else{
                System.out.println("#"+t+" "+min);
            }
        }
    }

    private static void dfs(int count, int[] card) {
        if(count > 5){
            return;
        }
        if(count >= min){
            return;
        }
        if(isSorted(card)){
            min = Math.min(min, count);
            return;
        }

        int left[] = new int[N/2];
        int right[] = new int[N/2];
        for(int i=0; i<N/2; i++){
            left[i] = card[i];
            right[i] = card[i+N/2];
        }


        for(int i=1; i<N; i++){
            int[] tmp = i<N/2?shuffle(i,left,right):shuffle(i-N/2,right,left);
            dfs(count+1, tmp);
        }
    }

    private static boolean isSorted(int[] card) {
        boolean up = true;
        boolean down = true;
        for(int i=0; i<N; i++){
            if(card[i] != i+1) up = false;
            if(card[i] != N-i) down =false;

            if(!up && !down) return false;
        }
        return true;
    }

    private static int[] shuffle(int mode, int left[], int[] right){
        int[] tmp = new int[N];
        int tmpidx = 0;
        int leftidx = 0;
        int rightidx = 0;

        while(leftidx < N/2 - mode){
            tmp[tmpidx++] = left[leftidx++];
        }

        int first = 0;
        while(leftidx < N/2 ){
            tmp[tmpidx++] = first%2==0? right[rightidx++] : left[leftidx++];
            first++;
        }

        while(rightidx < N/2){
            tmp[tmpidx++] = right[rightidx++];
        }
        return tmp;
    }
}
