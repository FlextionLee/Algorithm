package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15683_감시 {
    static class Pos{
        int x,y,type;
        public Pos(int x, int y, int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    static int ans;
    static int[][] map,copyMap;
    static ArrayList<Pos> list = new ArrayList<>();
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][][] info = {
            {

            },
            {
                    {true,false,false,false},
                    {false,true,false,false},
                    {false,false,true,false},
                    {false,false,false,true},
            },
            {
                    {true,false,true,false},
                    {false,true,false,true}
            },
            {
                    {true,true,false,false},
                    {false,true,true,false},
                    {false,false,true,true},
                    {true,false,false,true}
            },
            {
                    {true,true,false,true},
                    {true,true,true,false},
                    {false,true,true,true},
                    {true,false,true,true}
            },
            {
                    {true,true,true,true}
            }
    };
    static int[] dis;
    static int N,M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        N = n;
        M = m;
        map = new int[n][m];
        copyMap = new int[n][m];
        int cnt = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                copyMap[i][j] = map[i][j];
                if(map[i][j] > 0 && map[i][j] < 6){
                    list.add(new Pos(i,j,map[i][j]));
                }
                if(map[i][j] == 0){
                    cnt++;
                }
            }
        }
        dis = new int[list.size()];
        ans = Integer.MAX_VALUE;
        dfs(0);
        System.out.println(ans);
    }

    private static void dfs(int dep) {
        if(dep == list.size()){
            paint();
            int sum = getSum();
            ans = Math.min(sum,ans);
            clear();
            return;
        }

        Pos p = list.get(dep);

        for(int i=0; i<info[p.type].length; i++){
            dis[dep] = i;
            dfs(dep+1);
        }
    }

    private static void clear() {
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = copyMap[i][j];
            }
        }
    }

    private static int getSum() {
        int sum = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0) sum++;
            }
        }
        return sum;
    }

    private static void paint() {
        for(int i=0; i<dis.length; i++){
            Pos p = list.get(i);
            int t = dis[i];
            for(int k=0; k<4; k++){
                if(info[p.type][t][k]){
                    int nx = p.x;
                    int ny = p.y;

                    while(true){
                        nx += dx[k];
                        ny += dy[k];
                        if(nx<0||ny<0||nx>=N||ny>=M||map[nx][ny]==6) break;
                        map[nx][ny] = -1;
                    }
                }
            }
        }
    }
}
