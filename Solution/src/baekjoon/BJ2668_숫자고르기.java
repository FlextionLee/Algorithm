package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class BJ2668_숫자고르기 {
    static int[] map;
    static boolean[] visited;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        map = new int[n+1];
        for(int i=1; i<=n; i++){
            map[i] = Integer.parseInt(br.readLine());
        }
        visited = new boolean[n+1];
        list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            visited[i] = true;
            dfs(i,i,1);
            visited[i] = false;
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i : list){
            System.out.println(i);
        }
    }
    public static void dfs(int dep,int first, int count){
        if(!visited[map[dep]]){
            visited[map[dep]] = true;
            dfs(map[dep],first,count+1);
            visited[map[dep]] = false;
        }

        if(map[dep] == first){
            list.add(first);
        }

    }
}
