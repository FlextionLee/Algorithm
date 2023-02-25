package B형특강;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_새로운_불면증_치료법 {
    static int N;
    static int T;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            int res = (1<<10) -1;
            int count = 1;
            int target = 0;
            int answer = 0;
            while(true){
                int tmp = count * N;
                char[] chars = String.valueOf(tmp).toCharArray();
                System.out.println(tmp+" tmp");
                for(int i=0; i<chars.length; i++){
                    System.out.println(1<<chars[i]-'0');
                    target = target | (1<<chars[i]-'0');
                }
                if(target == res){
                    answer = tmp;
                    break;
                }
                count++;
            }
            System.out.println("#"+t+" "+answer);
        }
    }
}
