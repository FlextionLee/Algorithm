package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ1205_등수구하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Integer sco = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        if(n == 0){
            System.out.println(1);
            System.exit(0);
        }
        Integer[] map = new Integer[n+1];
        Integer[] grade = new Integer[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        map[n] = sco;
        Arrays.sort(map,Collections.reverseOrder());
        int prev = Integer.MAX_VALUE;
        int prevGrade = 1;
        int count = 0;
        for(int i=0; i<=n; i++){
            if(map[i] < prev){
                prev = map[i];
                grade[i] = prevGrade+count;
                prevGrade = grade[i];
                count = 1;
            }else if(map[i] == prev){
                grade[i] = prevGrade;
                count++;
            }
        }

        for(int i=n; i>=0; i--){
            if(map[i] == sco){
                if(i >= p){
                    System.out.println(-1);
                }else{
                    System.out.println(grade[i]);
                }
                break;
            }
        }
    }
}
