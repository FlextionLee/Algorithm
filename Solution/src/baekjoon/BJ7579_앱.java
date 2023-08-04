package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ7579_앱 {
    public static void main(String[] args) throws Exception{
        int N, M, sum=0;
        int memory[], cost[], dp[];

        //입력받기
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        memory= new int[N];
        cost= new int[N];

        st= new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            memory[i]= Integer.parseInt(st.nextToken());
        }

        st= new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            cost[i]= Integer.parseInt(st.nextToken());
            sum+=cost[i];
        }

        //dp
        dp= new int[sum+1];
        for(int i=0; i<N; i++) {
            for(int j=sum; j>=cost[i]; j--) {
                dp[j]=Math.max(dp[j], dp[j-cost[i]]+memory[i]);
            }
        }

        //출력
        for(int i=0; i<=sum; i++) {
            System.out.println(dp[i]);
            if(dp[i]>=M) {
                System.out.println(i);
                break;
            }
        }
    }
}
