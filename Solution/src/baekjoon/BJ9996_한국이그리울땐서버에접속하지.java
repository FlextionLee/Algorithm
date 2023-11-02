package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ9996_한국이그리울땐서버에접속하지 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        char front = pattern.charAt(0);
        char back = pattern.charAt(pattern.length()-1);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            String tmp = br.readLine();
            if(tmp.charAt(0) == front && tmp.charAt(tmp.length()-1) == back){
                sb.append("DA\n");
            }else{
                sb.append("NE\n");
            }
        }
        System.out.println(sb);
    }
}
