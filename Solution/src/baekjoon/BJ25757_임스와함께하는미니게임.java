package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ25757_임스와함께하는미니게임 {
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char c = st.nextToken().charAt(0);
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<n; i++){
            set.add(br.readLine());
        }

        switch (c){
            case 'Y':
                System.out.println(set.size()/1);
                break;
            case 'F':
                System.out.println(set.size()/2);
                break;
            case 'O':
                System.out.println(set.size()/3);
                break;
        }

    }
}
