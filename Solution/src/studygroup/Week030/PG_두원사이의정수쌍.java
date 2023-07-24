package studygroup.Week030;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class PG_두원사이의정수쌍 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[a];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<a; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        int b = Integer.parseInt((br.readLine()));
        int[] arr2 = new int[b];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<b; i++){
            arr2[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i=0; i<b; i++){
            int target = arr2[i];
            int lt = 0;
            int rt = arr.length-1;
            boolean ch = true;
            while(lt<=rt) {
                int mid = (lt + rt) / 2;
                if (arr[mid] == target) {
                    ch = false;
                    break;
                } else if (arr[mid] < target) {
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
            if(ch){
                System.out.println(0);
            }else{
                System.out.println(1);
            }
        }


    }
}
