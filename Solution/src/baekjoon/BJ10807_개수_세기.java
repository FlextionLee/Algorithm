package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10807_개수_세기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int count = 0;

        for(int i=0; i<n; i ++){
            int t = Integer.parseInt(st.nextToken());
            if(target == t){
                count++;
            }
        }
        System.out.println(count);

    }
}
