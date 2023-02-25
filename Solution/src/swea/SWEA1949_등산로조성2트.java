package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA1949_등산로조성2트 {
    static int T,N,K,ans;
    static int[][] map;
    static ArrayList<Node> list;
    static boolean[][] visited;
    static class Node{
        int x,y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            list = new ArrayList<>();
            int max = Integer.MIN_VALUE;

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N;j ++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max,map[i][j]);
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N;j ++){
                    if(map[i][j] == max){
                        list.add(new Node(i,j));
                    }
                }
            }

            ans = Integer.MIN_VALUE;
            visited = new boolean[N][N];

            for(int i=0; i<list.size(); i++){
                dfs(list.get(i).x,list.get(i).y,0,1);
                visited[list.get(i).x][list.get(i).y]=false; //비지트체크 안풀어줌..
                //메모리 조금이라도 덜쓰려고 반복문 돌때마다 새로 방문배열 생성 안했을때 끝까지 방문해제해주기
            }
            System.out.println("#"+t+" "+ans);
        }
    }

    private static void dfs(int x, int y, int count, int dis) {
        ans = Math.max(dis,ans);
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0||ny<0||nx>=N||ny>=N||visited[nx][ny]) continue;

            //현재 위치보다 내가 가야할 방향 위치가 작다 -> 갈 수 있다.
            if(map[nx][ny] < map[x][y]){
                //가자
                dfs(nx,ny,count,dis+1);
                //방문 해제
                visited[nx][ny] =false;
            }
            //아쉽게도 같거나 커서 갈 수가 없을때
            else{
                //마침 기회 한번을 쓰지 않았다면?
                if(count == 0){
                    //1부터 주어진 K만큼 깎음
                    for(int k=1; k<=K; k++){
                        //맵을 깎음
                        map[nx][ny] -= k;

                        //깎으니까 작아졌을때
                            if(map[nx][ny] < map[x][y]){
                                //가보자
                                dfs(nx,ny,count+1,dis+1);
                                //방문해제해주자
                                visited[nx][ny] = false;
                            }

                        //K만큼 깎았으니 다시돌아올때 깎은만큼 채워줘야함
                        map[nx][ny] += k; //이부분을 if문안으로 넣었음...
                    }
                }
            }
        }
    }
}
