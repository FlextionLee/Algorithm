package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 집 n개가 수직선 위에 있음 같은 좌표를 가지지 않음
 * 와이파이 C개를 설치하려함 최대한 많은 곳에서 와이파이를 사용하기를 원함
 * 한집에는 하나밖에 설치를 못하고 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하려고함
 *
 * 완전탐색  or 이분탐색
 * 조합 or 1 <= x <=(최소값과 최대값의 차이) 이 범위 안에 답이 존재한다는게 확정되어 있음
 */


public class BJ2110_공유기_설치 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] map = new int[n];

        for(int i=0; i<n; i++){
            map[i]= Integer.parseInt(br.readLine());
        }
        
        int answer = 0;
        Arrays.sort(map);

        int lt = 1;
        int rt = map[n-1];
  
        while(lt <= rt){
            int mid = (lt+rt)/2;

            if(wifi(map,mid) >= c){
                //이 리턴값이 c보다 크거나 같다는건?
                //가까운 값을 크게 만들 가능성이 있다는 것!
                answer = mid;
                lt=mid+1;
            }
            else{
                rt=mid-1;
            }
        }
        System.out.println(answer);
    }

    private static int wifi(int[] map, int mid) {
        int cnt = 1;
        int perv = map[0];
        for(int i =1; i<map.length; i++){
            if(map[i]-perv >= mid){
                cnt++;
                perv = map[i];
            }
        }
        return cnt;
    }
}
