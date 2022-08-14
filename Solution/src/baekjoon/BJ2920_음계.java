package baekjoon;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class BJ2920_음계 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[8];

        for(int i=0; i<8; i++){
            a[i] = sc.nextInt();
        }

        int[] b = a.clone();
        Arrays.sort(b);

        if(Arrays.equals(a,b)){
            System.out.println("ascending");
        }
        else {
            for(int i=0; i<8; i++){
                for(int j=i+1; i<8; i++){
                    if(b[i] < b[j]){
                        int tmp =b[i];
                        b[i] =b[j];
                        b[j] =tmp;
                    }
                }
            }

            System.out.println(Arrays.toString(b));

            if(Arrays.equals(a,b)){
                System.out.println("descending");
            }
            else{
                System.out.println("mixed");
            }
        }

    }
}
