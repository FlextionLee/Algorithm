package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Bj2887_행성_터널 {
    static int N;
    static int[] parents;
    static Planet[] planets;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        planets = new Planet[N];

        for(int i=0; i<N ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(x,y,weight);
        }

        //Arrays.sort(planets, (p1, p2) -> );
    }


    static void makeSet(){
        for(int i=1; i<=N; i++){
            parents[i] = i;
        }
    }

    static int findSet(int x){
        if(parents[x] == x){
            return x;
        }
        else{
            return parents[x] = findSet(parents[x]);
        }
    }

    static boolean union(int x, int y){
        int px = findSet(x);
        int py = findSet(y);

        if(px == py){
            return false;
        }
        if(px < py){
            parents[py] = px;
        }
        else{
            parents[px] = py;
        }
        return true;
    }



    static class Planet{
        int x,y,weight;
        int min;
        public Planet(int x, int y, int weight){
            this.x = x;
            this.y =y;
            this.weight = weight;
        }
    }
}
