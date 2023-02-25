package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class BJ2661_좋은수열 {
    static int N, ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs("",0);

    }

    private static void dfs(String s, int num) {
        if(num == N){
            System.out.println(s);
            System.exit(0);
        }
        for(int i=1; i<=3; i++){
            if(check(s, i)){
                dfs(s+String.valueOf(i),num+1);
            }
        }
    }

    private static boolean check(String s, int num) {
        String tmp = s+String.valueOf(num);

        for(int i=1; i<=tmp.length()/2; i++){
            if(tmp.substring(tmp.length()-i).equals(
                    tmp.substring(tmp.length()-2*i, tmp.length()-i))
            ) return false;
        }
        return true;
    }
}