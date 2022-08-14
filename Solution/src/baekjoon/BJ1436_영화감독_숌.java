package baekjoon;

import java.util.Scanner;

public class BJ1436_영화감독_숌 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int i = 666;
        int count =0;
        while(true){
            if(String.valueOf(i).contains("666")){
                count++;
                if(n==count){
                    System.out.println(i);
                    break;
                }
            }
            i++;
        }

    }
}
