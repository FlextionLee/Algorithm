package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1072_게임 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = getPer(x,y);
        int ans = -1;
        int lt = 0;
        int rt = (int) 1e9;
        while(lt <= rt){
            int mid = (lt+rt)/2;
            int val = getPer(x+mid, y+mid);
            if(val != z){
                ans = mid;
                rt = mid-1;
            }else{
                lt = mid+1;
            }
        }
        System.out.println(ans);
    }

    private static int getPer(int x, int y) {
        return (int)((long)y*100/x);
    }
}
