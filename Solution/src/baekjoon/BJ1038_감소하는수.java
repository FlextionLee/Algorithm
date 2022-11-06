package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ1038_감소하는수 {
    static int N;
    static long ans=-1;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        dfs(0,0);
        if(N<=10){
            System.out.println(N);
        }
        else if(N > 1022){
            System.out.println(-1);
        }
        else{
            for(int i=0; i<10; i++){
                dfs(1,i);
            }
            Collections.sort(list);
            System.out.println();

            System.out.println(list.get(N));

        }
    }

    private static void dfs(int depth,int num) {
        System.out.println(num);
        if(depth > 10){
            return;
        }
        list.add(num);
        for(int i=0; i<10; i++){
            if(num % 10 > i){
                dfs(depth+1,(num*10)+i);
            }
        }
    }
}
