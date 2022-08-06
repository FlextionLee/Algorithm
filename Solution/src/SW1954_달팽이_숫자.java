import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW1954_달팽이_숫자 {
        static int dx[] = {0,1,0,-1};
        static int dy[] = {1,0,-1,0};
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int test = Integer.parseInt(br.readLine());

            for(int tc=1; tc<=test; tc++) {
                int n = Integer.parseInt(br.readLine());
                int map[][] = new int[n][n];
                int num = 1;
                int x = 0;
                int y = 0;
                map[x][y] = num++;
                int idx = 0;

                while(true) {
                    if(num>n*n)break;

                    int nx = x+dx[idx%4];
                    int ny = y+dy[idx%4];

                    if(nx <0 || nx >=n || ny<0 || ny>= n || map[nx][ny] != 0) {
                        idx++;
                        continue;
                    }
                    map[nx][ny] = num++;
                    x = nx;
                    y = ny;
                }

                System.out.println("#"+tc);
                for(int i=0; i<n; i++) {
                    for(int j=0; j<n; j++) {
                        System.out.print(map[i][j]+" ");
                    }
                    System.out.println();
                }

            }
        }

    }

