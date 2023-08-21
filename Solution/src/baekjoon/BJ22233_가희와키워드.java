package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ22233_가희와키워드 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String str = br.readLine();
            map.put(str,1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            String str = br.readLine();
            String[] arr = str.split(",");
            for(int j=0; j<arr.length; j++){
                if(map.containsKey(arr[j])){
                    map.remove(arr[j]);
                }
            }
            sb.append(map.keySet().size()+"\n");
        }
        System.out.println(sb);
    }
}
