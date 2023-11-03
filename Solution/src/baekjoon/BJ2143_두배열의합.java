package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;

public class BJ2143_두배열의합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> aa = new ArrayList<>();
        ArrayList<Integer> bb = new ArrayList<>();

        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += a[j];
                aa.add(sum);
            }
        }
        for(int i=0; i<m; i++){
            int sum = 0;
            for(int j=i; j<m; j++){
                sum += b[j];
                bb.add(sum);
            }
        }
        Collections.sort(aa);
        Collections.sort(bb);
        int lt = 0;
        int rt = bb.size()-1;
        long count = 0;
        while(lt<aa.size() && rt>=0){
            int sum = aa.get(lt) + bb.get(rt);
            if(sum == t){
                int ta = aa.get(lt);
                int tb = bb.get(rt);
                long lcnt = 0;
                long rcnt = 0;
                while(lt < aa.size() && aa.get(lt) == ta){
                    lcnt++;
                    lt++;
                }
                while(rt >= 0 && bb.get(rt) == tb){
                    rcnt++;
                    rt--;
                }
                count += lcnt*rcnt;
            }else if(sum > t){
                rt--;
            }else{
                lt++;
            }
        }
        System.out.println(count);
    }
}
