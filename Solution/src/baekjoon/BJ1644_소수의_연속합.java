package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1644_소수의_연속합{
    public static void main(String[]args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a= Integer.parseInt(br.readLine());
        boolean arr[] = new boolean[a/2+2];
        int[] tmp = new int[a/2+2];
        int idx = 0;

        arr[1] = true;
        for(int i=2; i<arr.length; i++){
            if(!arr[i]){
                if(i<a) {
                    tmp[idx++] = i;
                }
                for(int j=i+i; j<arr.length; j+=i){
                    arr[j] = true;
                }
            }
        }
        int lt = 0;
        int rt = 0;
        int sum = 0;
        int count = 0;

        while(lt<=rt && rt<tmp.length){
            if(sum < a){
                sum+=tmp[rt++];
            }
            else{
                if(sum==a){
                    count++;
                }
                sum-=tmp[lt++];
            }
        }

        boolean ch = false;
        for(int i=2; i<=(int)Math.sqrt(a); i++){
            if(a%i==0) {
                ch = true;
                break;
            }
        }

        count = ch||a==1?count:count+1;
        System.out.println(count);
        }
    }
