package studygroup.Week029;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class practi{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[] arr = new char[num];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<num; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        int lt = 0;
        int rt = 0;
        int ans = 0;

        while(lt<=rt && rt < arr.length){
            if(arr[rt] == '0'){
                if(n > 0){
                    rt++;
                    n--;
                }else{
                    //0을 만날때까지 lt++
                    while(arr[lt] == '1'){
                        lt++;
                    }
                    //0을 지나쳐야 하니까 lt++
                    lt++;
                    n++;
                }
            }else{
                rt++;
            }
            ans = Math.max(ans,rt-lt);
        }
        System.out.println(ans);
    }
}