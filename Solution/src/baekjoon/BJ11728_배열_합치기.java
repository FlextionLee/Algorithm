package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11728_배열_합치기 {
    static int A,B;
    static int[] arr;
    static int [] brr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[A];
        brr = new int[B];
        int result[] = new int[A+B];

        int ap =0;
        int bp =0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<A; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<B; i++){
            brr[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;

        while(ap<A && bp<B){
            if(arr[ap] < brr[bp]){
                result[idx++] = arr[ap++];
            }
            else{
                result[idx++] = brr[bp++];
            }
        }
        while(ap<A) result[idx++] = arr[ap++];
        while(bp<B) result[idx++] = brr[bp++];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i< result.length; i++){
            sb.append(result[i]+ " ");
        }
        System.out.println(sb.toString());
    }
}
