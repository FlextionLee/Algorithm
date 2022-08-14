package baekjoon;

import java.util.Scanner;

public class BJ1085_직사각형에서_탈출 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int zero = (x>y)?y:x;
        int end  = (w-x > h-y)?h-y:w-x;
        System.out.println(zero>end?end:zero);
    }
}
