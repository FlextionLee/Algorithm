package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15666_N과M12 {

    static int N,M;
    static Integer arr[];
    static int result[];
    static StringBuilder sb;
    static boolean visited[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        arr = new Integer[N];
        result = new int[M];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0,0);
        System.out.println(sb.toString());
    }
    private static void dfs(int cnt,int start){
        if(cnt == M){
            for(int i=0; i<M; i++){
                sb.append(result[i]+" ");
            }
            sb.append("\n");
            return;
        }
        int past = -1;
        for(int i=start; i<arr.length; i++){
            int now = arr[i];
            if(past == now){
                continue;
            }else{
                past = now;
                result[cnt] = arr[i];
                dfs(cnt+1,i);
            }
        }
    }
}
