package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ1043_거짓말 {
    static int[] parent;
    static HashSet<Integer> knower;
    static ArrayList<Integer>[] list;
    static boolean[] info;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[m];
        parent = new int[n+1];
        knower = new HashSet<>();
        info = new boolean[m];

        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        //거짓말을 알 수 있는 사람
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for(int i=0; i<k; i++){
            knower.add(Integer.parseInt(st.nextToken()));
        }

        //파티 정보
        for(int i=0; i<m; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            for(int j=0; j<d; j++){
                int person = Integer.parseInt(st.nextToken());
                list[i].add(person);
            }
        }

        for(int i=0; i<list.length; i++){
            for(int j=0; j<list[i].size()-1; j++){
                union(list[i].get(j),list[i].get(j+1));
            }
        }

        int ans = 0;
        for(int i=0; i<m; i++){
            boolean ch = true;
            for(int j=0; j<list[i].size(); j++){
                int tmp = find(list[i].get(j));
                for(int l : knower){
                    if(find(l) == tmp) ch = false;
                }
            }
            if(ch) ans++;
        }

        System.out.println(ans);

    }

    private static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if(fx != fy){
            if(fx > fy){
                parent[fx] = fy;
            }else{
                parent[fy] = fx;
            }
        }
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}
