package baekjoon;

import java.io.BufferedReader;
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
        int ans =0;
        while(lt<=rt){
            if(rt >= n) break;
            //맵에 있는 값일때
            if(map.containsKey(arr[rt])){
                //중복허용 최대치로 갔을때
                if(map.get(arr[rt]) == k){
                    while(true){
                        if(arr[lt] == arr[rt]){
                            if(map.get(arr[lt]) == 1){
                                map.remove(arr[lt]);
                            }else{
                                map.put(arr[lt], map.get(arr[lt])-1);
                            }
                            lt++;
                            break;
                        }
                        lt++;
                    }
                    //중복허용이 될 때
                }else{
                    map.put(arr[rt],map.get(arr[rt])+1);
                }
            }else{
                map.put(arr[rt],map.getOrDefault(arr[rt],0)+1);
            }
            System.out.println(lt+" "+rt);
            ans = Math.max(ans, (rt-lt));
            rt++;
        }
        System.out.println(ans);
    }
}
