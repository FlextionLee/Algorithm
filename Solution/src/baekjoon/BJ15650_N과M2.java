package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15650_N과M2 {

    static public int n,m;
    static public boolean[] isSelected;
    static public int[] arr;
    static public StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());

        arr = new int[m];
        isSelected = new boolean[n+1];

        sb = new StringBuilder();
        dfs(0,1);
    }

    private static void dfs(int cnt, int start) {
        if(cnt == m){
            for(int i=0; i<m; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=start; i<=n; i++){
            if(isSelected[i]){
                continue;
            }
            isSelected[i] = true;
            arr[cnt] = i;
            dfs(cnt+1, i+1);
            isSelected[i] = false;
        }
    }
}
