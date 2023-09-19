package baekjoon;
import java.util.*;
import java.io.*;

public class SOFTTEER_자동차테스트 {
    public static void main(String args[])throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0; i<n; i++){
            map.put(arr[i],i+1);
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<m; i++){
            int t = Integer.parseInt(br.readLine());
            if(map.containsKey(t)){
                int tNum = map.get(t);
                int left = tNum -1;
                int right = n - tNum;
                sb.append((left * right) + "\n");
            }else{
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
}
