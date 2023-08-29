package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ20922_겹치는건싫어 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int lt = 0;
        int rt = 0;
        int ans = 0;
        while(lt<=rt && rt<n){
            //나왔던 수
            if(map.containsKey(arr[rt])) {
                //k번 나왔으면 더이상 진행이 불가능 lt를 증가시켜보자
                if (map.get(arr[rt]) == k) {
                    while (map.get(arr[rt]) == k) {
                        map.put(arr[lt], map.get(arr[lt]) -1);
                        lt++;
                    }
                }
            }
            map.put(arr[rt] , map.getOrDefault(arr[rt],0)+1);
            //안나왔던 수
            ans = Math.max(ans,(rt-lt+1));
            rt++;
        }
        System.out.println(ans);
    }
}
