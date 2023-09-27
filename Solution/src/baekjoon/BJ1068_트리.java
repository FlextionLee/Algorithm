package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1068_트리 {
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] info = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for(int i=0; i<n; i++){
            int m = Integer.parseInt(st.nextToken());
            info[i] = m;
            if(m == -1){
                root = i;
            }
        }

        int remove = Integer.parseInt(br.readLine());

        dfs(remove,info);
        if(info[root] == -2){
            System.out.println(0);
            System.exit(0);
        }
        dfs2(root,info);
        System.out.println(ans);
    }

    private static void dfs(int remove,int[] info) {
        info[remove] = -2;
        for(int i=0; i<info.length; i++){
            if(info[i] == remove){
                dfs(i,info);
            }
        }
    }
    private static void dfs2(int node,int[] info) {
        boolean ch = false;

        for(int i=0; i<info.length; i++){
            if(info[i] == node){
                dfs2(i,info);
                ch = true;
            }
        }
        if(!ch){
            ans++;
        }
    }
}
