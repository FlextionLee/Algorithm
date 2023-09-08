package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1339_단어수학 {
    static class Info{
        int idx;
        char c;
        public Info(int idx, char c){
            this.idx = idx;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        int max = 0;
        for(int i=0; i<arr.length; i++){
            arr[i] = br.readLine();
            max = Math.max(arr[i].length(),max);
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int num = 9;
        for(int i=0; i<max; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[j].length() <= i) continue;
                if(!map.containsKey(arr[j].charAt(i))){
                    map.put(arr[j].charAt(i),num);
                    num--;
                }
            }
        }
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            String s = "";
            for(int j=0; j<arr[i].length(); j++){
                s += map.get(arr[i].charAt(j));
            }
            ans += Integer.parseInt(s);
        }
        System.out.println(ans);

    }
}
