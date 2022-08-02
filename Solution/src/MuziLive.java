import java.util.*;

public class MuziLive {
    public static void main(String[] args) {
        //독특한 방식의 먹방
        //회전판에 n개의 음식 각음식은 1부터 번호가 붙어있음
        //음식을 섭취하는데 일정 시간 소요
        //1번 부터 먹기 시작
        // 1초동안만 먹음 쭉 돌다가
        //먹방을 시작한지 k초 후에 방송 중단
        //네트워크 정상화 후 다시 방송을 이어갈때, 몇번 음식부터 먹어야하는지 알고싶다.
        int food[] = {3,1,2};
        solution(food,5);

    }
    public static class Food implements Comparable<Food>{
        int food;
        int idx;
        public Food(int food, int idx){
            this.food = food;
            this.idx = idx;
        }

        @Override
        public int compareTo(Food o) {
            return this.food-o.food;
        }
    }
    public static int solution(int[] food_times, int k){
        Queue<Food> q = new LinkedList<>();
        List<Food> list = new ArrayList<>();

        for(int i=0; i<food_times.length; i++){
            list.add(new Food(food_times[i],i+1));
        }

        Collections.sort(list);

        return 0;
    }
}
