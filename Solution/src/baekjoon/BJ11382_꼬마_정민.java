package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11382_꼬마_정민 {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        System.out.println(Long.parseLong(st.nextToken())+Long.parseLong(st.nextToken())+Long.parseLong(st.nextToken()));
    }
}
