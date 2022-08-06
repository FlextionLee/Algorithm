package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2023_신기한_소수 {
        static StringBuilder sb;
    public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            dfs(0, n);
           System.out.println(sb.toString());
        }

        static void dfs(int num, int depth) {
            if(depth==0) {
                sb.append(num+"\n");
                return;
            }
            for(int i=1; i<10; i++) {
                int tmp = 10*num +i;
                if(isPrime(tmp)) {
                    dfs(tmp, depth-1);
                }
            }
        }

        static boolean isPrime(int num) {
            if(num <2) return false;
            for(int i=2 ; i*i<=num; i++) {
                if(num%i ==0) {
                    return false; //num이 i의 배수면 소수가 아니므로 false
                }
            }
            return true;
        }
}


