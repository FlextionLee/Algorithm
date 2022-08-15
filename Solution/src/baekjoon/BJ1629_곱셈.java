package baekjoon;

import java.util.Scanner;

public class BJ1629_곱셈 {
    static int n,m,k;
    static long num=1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        dfs(0);
        System.out.println(num);
    }

    private static void dfs(int depth) {
        if(depth==m){
            return;
        }
        num = num*n%k;
        dfs(depth+1);
    }
}
