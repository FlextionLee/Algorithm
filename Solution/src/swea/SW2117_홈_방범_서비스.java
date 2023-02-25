package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW2117_홈_방범_서비스 {
    static int T,N,M,sum,ans= Integer.MIN_VALUE;
    static int map[][];
    static int dx[] = {0,0,1,-1};
    static int dy[] = {-1,1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for(int i=0; i<N; i++){
                st= new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] ==1){
                        sum++;
                    }
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] == 1){
                        bfs(i,j,1);
                    }
                    else{
                        bfs(i,j,0);
                    }
                }
            }

            System.out.println(ans);


        }
    }

    private static void bfs(int x, int y, int house) {
        Queue<int[]> q= new ArrayDeque<>();
        q.add(new int[] {x,y,1});
        boolean visited[][] = new boolean[N][N];
        visited[x][y]=true;
        int home = house;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cost = (tmp[2] * tmp[2]) + (tmp[2]-1)*(tmp[2]-1);
            int benefit = (home * M) - cost;
            if(benefit >= 0){
                System.out.println(cost +" " + benefit+" "+home+" "+tmp[0]+" "+tmp[1]);
            }
            if(benefit >= 0){
                ans = Math.max(ans, home);
            }

            for(int k=0; k<4; k++){
                int nx = tmp[0] + dx[k];
                int ny = tmp[1] + dy[k];

                if(nx<0||nx>=N||ny<0||ny>=N) continue;
                if(visited[nx][ny])continue;
                if(map[nx][ny]==1){
                    home++;
                }
                q.add(new int[] {nx,ny,tmp[2]+1});
                visited[nx][ny] = true;
            }
        }

    }
}
