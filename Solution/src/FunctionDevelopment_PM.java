import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionDevelopment_PM {
    public static void main(String[] args) {
        int[] prog = {95,90,99,99,80,99};
        int[] speed = {1,1,1,1,1,1};
        System.out.println(Arrays.toString(solution(prog,speed)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        int tmp[] = new int[speeds.length];

        for(int i=0; i<progresses.length; i++){
            tmp[i] = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i] != 0){
                tmp[i]++;
            }
        }
        for(int i=1; i<tmp.length; i++){
            if(tmp[i-1] > tmp[i]){
                tmp[i] = tmp[i-1];
            }
        }

        List<Integer> list = new ArrayList<>();
        int arrTmp = tmp[0];
        int count = 1;

        for(int i=1; i<tmp.length; i++){
            if(tmp[i] == arrTmp){
                count++;
            }
            else{
                list.add(count);
                count = 1;
                arrTmp = tmp[i];
            }
        }
        list.add(count);

        int[] result = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++) {
            result[i] = list.get(i).intValue();
        }
        return result;
    }
}
