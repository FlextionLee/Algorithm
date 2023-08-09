package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ9017_크로스컨트리 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int n = Integer.parseInt(br.readLine());
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int max = 0;
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max,arr[i]);
            }
            boolean[] ch = new boolean[max+1];
            for(int i=1; i<=max; i++){
                int count = 0;
                for(int j=0; j<n; j++){
                    if(arr[j] == i){
                        count++;
                    }
                }
                if(count >= 6){
                    ch[i] = true;
                }
            }
            int grade = 1;
            for(int i=0; i<n; i++){
                if(ch[arr[i]]){
                    if(map.containsKey(arr[i])){
                        ArrayList<Integer> list = map.get(arr[i]);
                        list.add(grade);
                        grade++;
                    }else{
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(grade);
                        grade++;
                        map.put(arr[i],list);
                    }
                }
            }
            int ans = 0;
            int min = Integer.MAX_VALUE;
            int five = 0;

            for(int key : map.keySet()){
                ArrayList<Integer> list = map.get(key);
                Collections.sort(list);
                int sum = 0;
                for(int i=0; i<4; i++){
                    sum += list.get(i);
                }
                if(sum < min){
                    min = sum;
                    ans = key;
                    five = list.get(4);
                }if(sum == min){
                    if(five > list.get(4)){
                        min = sum;
                        ans = key;
                        five = list.get(4);
                    }
                }
            }
            System.out.println(ans);
        }
    }
}