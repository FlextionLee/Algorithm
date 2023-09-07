package baekjoon;
import java.util.*;
public class PG_징검다리건너기 {
    static class Data{
        int index;
        int value;
        public Data(int value, int index){
            this.index = index;
            this.value = value;
        }
    }
    public static int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;

        int n = stones.length;
        ArrayDeque<Data> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            int cur = stones[i];
            if(!q.isEmpty() && q.peek().index <= i - k) {
                q.pollFirst();
            }
            while(!q.isEmpty() && q.peekLast().value <= cur) {
                q.pollLast();
            }
            q.add(new Data(cur, i));
            if(answer >= q.peekFirst().value && i >= k - 1) {
                answer = q.peekFirst().value;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1},3));
    }
}
