package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1194_달이차오른다가자 {
    static int N,M,sx,sy,ans;
    static char[][] map;
    static boolean[] alp;
    static boolean[] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        alp = new boolean[26];
        visited = new boolean[26];

        map = new char[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == '0'){
                    sx = i;
                    sy = j;
                }
            }
        }
        ans = -1;
        bfs(sx,sy);
        System.out.println(ans);
    }

    private static void bfs(int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {sx,sy,0});

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int k=0; k<4; k++){
                int nx = tmp[0]+dx[k];
                int ny = tmp[1]+dy[k];

                if(nx<0||ny<0||nx>=N||ny>=M||map[nx][ny]=='#') continue;

                System.out.println(nx+" "+ny+" "+tmp[2]);
                if(map[nx][ny]=='.'){
                    q.add(new int[] {nx,ny,tmp[2]+1});
                }
                else if(map[nx][ny]=='1'){
                    ans = tmp[2];
                    return;
                }
                else if(map[nx][ny]=='0'){
                    q.add(new int[] {nx,ny,tmp[2]+1});
                }
                else{
                    int alpha = map[nx][ny];
                    if(alpha >= 97){
                        alp[alpha-97] = true;
                        q.add(new int[] {nx,ny,tmp[2]+1});
                    }
                    else{
                        if(alp[alpha-65]){
                            q.add(new int[] {nx,ny,tmp[2]+1});
                        }
                    }
                }
            }
        }
    }
}
