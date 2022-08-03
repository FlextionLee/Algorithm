import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW2805_농작물_수확하기 {

    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=test; tc++){
            int n = Integer.parseInt(br.readLine());

            int sum = 0;
            int wide = 0;
            int half = n/2;
            int sx = half;
            int ex = half;

            for(int i=0; i<n; i++){
                char[] arr = br.readLine().toCharArray();
                for(int j=sx; j<=ex; j++){
                    sum +=arr[j]-'0';
                }
                if(i<half){
                    sx--;
                    ex++;
                }
                else{
                    sx++;
                    ex--;
                }
            }
            System.out.println("#"+tc+" "+sum);

        }
    }
}
