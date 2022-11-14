package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1824_혁진이의프로그램검증2트 {
    static int T,R,C;
    static char[][] oper;
    static String ans;
    //상우하좌
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static boolean[][][][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            oper = new char[R][C];

            boolean ch = false;
            for(int i=0; i<R; i++){
                String str = br.readLine();
                for(int j=0; j<C; j++){
                    oper[i][j] = str.charAt(j);
                    if(oper[i][j] == '@'){
                        ch = true;
                    }
                }
            }
            if(!ch){
                System.out.println("#"+t+" NO");
                continue;
            }
            ans = "NO";
            visited = new boolean[R][C][16][4];
            dfs(0,0,0,1);
            System.out.println("#"+t+" "+ans);
        }
    }
    //상우하좌
    private static void dfs(int x, int y, int memory, int dis) {
        if(visited[x][y][memory][dis]){
            return;
        }
        visited[x][y][memory][dis] =true;

        char cur = oper[x][y];
        int tdis = dis;
        int tmemory = memory;
        if(cur == '@'){
            ans = "YES";
            return;
        }
        if(Character.isDigit(cur)){
            tmemory = cur - '0';
        }
        else if(cur == '<') tdis = 3;
        else if(cur == '>') tdis = 1;
        else if(cur == '^') tdis = 0;
        else if(cur == 'v') tdis = 2;
        else if(cur == '+') tmemory = (tmemory==15)?0:tmemory+1;
        else if(cur == '-') tmemory = (tmemory==0)?15:tmemory-1;
        else if(cur == '_'){
            if(memory == 0){
                tdis = 1;
            }
            else{
                tdis = 3;
            }
        }
        else if(cur == '|'){
            if(memory == 0){
                tdis = 2;
            }
            else{
                tdis = 0;
            }
        }
        else if(cur == '?'){
            int nx = 0;
            int ny = 0;
            for(int i=0; i<4; i++){
                nx = x + dx[i];
                ny = y + dy[i];

                if(nx<0) nx = R-1;
                else if(nx>=R) nx = 0;
                else if(ny<0) ny =C-1;
                else if(ny>=C) ny = 0;
                dfs(nx,ny,tmemory,i);
            }
        }
        if(cur != '?'){
            int nx = x+dx[tdis];
            int ny = y+dy[tdis];

            if(nx<0) nx = R-1;
            else if(nx>=R) nx = 0;
            else if(ny<0) ny =C-1;
            else if(ny>=C) ny = 0;

            dfs(nx, ny,tmemory,tdis);
        }
    }
}





























