package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BJ2607_비슷한단어 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int ans = 0;
        int alp[] = new int[26];

        for(int i=0; i<s.length(); i++){
            alp[s.charAt(i)-'A']++;
        }

        for(int i=0; i<n-1; i++){
           int[] tmp = alp.clone();
           String tmps = br.readLine();
           int count = 0;
           for(int j=0; j<tmps.length(); j++){
               if(tmp[tmps.charAt(j)-'A'] > 0){
                   count++;
                   tmp[tmps.charAt(j)-'A'] -= 1;
               }
           }
           if(tmps.length() == s.length()){
               if(count == s.length() -1 || count == s.length()){
                   ans++;
               }
           }else if(tmps.length()-1 == s.length()){
               if(count == s.length()){
                   ans++;
               }
           }else if(tmps.length()+1 == s.length()){
               if(count == s.length()-1){
                   ans++;
               }
           }
        }
        System.out.println(ans);
    }
}
