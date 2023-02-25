package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1253_좋다 {
    static int N,ans;
    static int[] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);
        for(int i=0; i<N; i++){
            int lt = 0;
            int rt = N-1;
            int num = map[i];
            while(lt<rt){
                if(lt == i) lt++;
                else if(rt == i) rt--;

                else{
                    if(num == map[lt]+map[rt]){
                        ans++;
                        break;
                    }
                    else if(num < map[lt]+map[rt]) rt--;
                    else lt++;
                }
            }
        }
        System.out.println(ans);
    }
}