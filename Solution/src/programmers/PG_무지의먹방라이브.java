package programmers;
import java.util.*;
public class PG_무지의먹방라이브 {
    public static class Food{
        int idx;
        int time;
        public Food(int idx, int time){
            this.time = time;
            this.idx = idx;
        }

    }

    public int solution(int[] food_times, long k) {
        PriorityQueue<Food> pq = new PriorityQueue<>((o1,o2)->{
            return o1.time - o2.time;
        });
        long sum = 0;
        for(int i=0; i<food_times.length; i++){
            pq.add(new Food(i+1,food_times[i]));
            sum += food_times[i];
        }
        if(sum <= k){
            return -1;
        }
        long total = 0;   // 먹기 위해 사용한 시간
        long prev = 0;  // 직전에 다 먹은 음식 시간
        long len = food_times.length;    // 남은 음식 개수

        while (total + ((pq.peek().time - prev) * len) <= k) {
            int now = pq.poll().time;
            total += (now - prev) * len;
            len -= 1;
            prev = now;
        }
        ArrayList<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.sort(result, new Comparator<Food>() {
            @Override
            public int compare(Food a, Food b) {
                return Integer.compare(a.idx, b.idx);
            }
        });

        return result.get((int) ((k - total) % len)).idx;
    }
}
