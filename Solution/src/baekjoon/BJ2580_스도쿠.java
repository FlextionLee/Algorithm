package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2580_스도쿠 {
    static int[][] map = new int [9][9];
    static int count =0;
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    count++;
                    list.add(new int[]{i, j});
                }
            }
        }
        dfs(0);

    }
    private static void dfs(int depth) {
        if(depth == count){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.exit(0);
            return;
        }

        int[] tmp = list.get(depth);

        boolean[] check = check(tmp[0],tmp[1]);

        for(int i=1; i<10; i++){
            if(!check[i]){
                /**
                 * false인 놈들만
                 */
                map[tmp[0]][tmp[1]] = i;
                dfs(depth+1);
                map[tmp[0]][tmp[1]] = 0;
            }
        }
    }
    private static boolean[] check(int nx,int ny) {
        /**
         * 가로, 세로 , 박스 에서 한번도 나오지 않은 놈은 false
         *
         */
        boolean check[] = new boolean[10];
        for(int i=0; i<9; i++){
            check[map[i][ny]] = true;
        }
        for(int j=0; j<9; j++){
            check[map[nx][j]] = true;
        }

        int sx = nx/3*3;
        int sy = ny/3*3;

        for(int i=sx; i<sx+3; i++){
            for(int j=sy; j<sy+3; j++){
                check[map[i][j]] = true;
            }
        }
        return check;
    }

}