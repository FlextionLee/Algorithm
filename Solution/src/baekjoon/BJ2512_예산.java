package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2512_예산 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] budget = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i=0; i<n; i++){
            budget[i] = Integer.parseInt(st.nextToken());
            sum += budget[i];
        }

        int m = Integer.parseInt(br.readLine());
        Arrays.sort(budget);

        if(sum <= m){
            System.out.println(budget[budget.length-1]);
            System.exit(0);
        }

        int lt = 0;
        int rt = budget[budget.length-1];
        int ans = 0;
        while(lt<=rt){
            int mid = (lt+rt)/2;

            if(isPossible(budget,mid,m)){
                rt = mid -1;
                ans = mid;
            }else{
                lt = mid +1;
            }
        }
        System.out.println(ans);
    }

    private static boolean isPossible(int[] budget, int mid, int m) {
        int sum = 0;
        for(int i=0; i<budget.length; i++){
            if(mid <= budget[i]){
               sum += mid;
            }else{
                sum += budget[i];
            }
        }
        if(sum <= m){
            return false;
        }
        return true;
    }
}
