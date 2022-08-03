import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Guild {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
           arr[i] = Integer.parseInt(st.nextToken());
        }
        // 최대한 많은 그룹을 만들기 위해선 제일 작은 단위 부터
        // 묶으면서 진행하기 위해 오름차순 정렬
        Arrays.sort(arr);

        int count = 0;
        int group = 0;

        for(int i=0; i<n; i++){
            count++;// 카운트가 증가하면서 정렬된 단위를 만날때
            if(count == arr[i]){
                group++;// 그룹이 생긴다.
                count = 0;//그룹이 생겼다면 0으로 초기화
            }
        }
        System.out.println(group);
    }
}
