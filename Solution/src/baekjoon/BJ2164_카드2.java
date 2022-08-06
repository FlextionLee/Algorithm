package baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class BJ2164_카드2 {
    //N장의 카드 1부터 N까지 번호가 붙어있다.
    //1번카드가 제일 위에 N번이 젤 아래
    //동작방식 제일 위에 있는 카드를 버림
    //그리고 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮김
    //제일 마지막에 남게 되는 카드를 구하라
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n= sc.nextInt();
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            q.offer(i);
        }
        while(q.size()>1){
            q.poll();
            q.add(q.poll());
        }
        System.out.println(q.getLast());
    }
}
