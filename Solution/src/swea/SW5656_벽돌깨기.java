package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SW5656_벽돌깨기 {
    static int T,N,W,H,ans;
    static int[][] map;
    static int[] target;
    static class Node{
        int x;
        int y;
        int power;
        public Node(int x, int y, int power){
            this.x=x;
            this.y=y;
            this.power = power;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T= Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            target = new int[N];
            ans = Integer.MAX_VALUE;

            for(int i=0; i<H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W;j ++){
                 map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //중복 순열로 모든 경우의 수 탐색
            perm(0);
            System.out.println("#"+t+" "+ans);
        }
    }

    private static void perm(int depth) {
        if(depth ==N){
            //complete
            simul();
            return;
        }

        for(int i=0; i<W; i++){
            target[depth] = i;
            perm(depth+1);
        }
    }

    private static void simul() {
        int[][] tmp = new int[H][W];
        for (int i = 0; i < H; i++) {
            tmp[i] = map[i].clone();
        }

        Queue<Node> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            //선택된 컬럼하나를 가져옴
            int c = target[i];

            for (int j = 0; j < H; j++) {
                //컬럼c 기준 밑으로 내려가면서 0이면 지나가고
                if (tmp[j][c] == 0) continue;
                // 1이면 0으로바꾸고 다음 컬럼 찾으러가고
                else if (tmp[j][c] == 1) {
                    tmp[j][c] = 0;
                    break;
                }
                // 1이 아니면 q에담고 q에 담긴 녀석을 터트리면서
                // 또다른 녀석이 나타나면 또 q에담고 지우는 과정을 반복한다.
                // 큐가 비어있으면 물리엔진 적용 하고 다음 컬럼 찾으러 가기
                else {
                    q.add(new Node(j, c, tmp[j][c] - 1));
                    tmp[j][c] = 0;

                    while (!q.isEmpty()) {
                        Node node = q.poll();
                        //가로처리
                        int sr = (node.y - node.power < 0) ? 0 : node.y - node.power;
                        int er = (node.y + node.power >= W) ? W - 1 : node.y + node.power;

                        for (int k = sr; k <= er; k++) {
                            if (tmp[node.x][k] > 1) {
                                q.add(new Node(node.x, k, tmp[node.x][k] - 1));
                                tmp[node.x][k] = 0;
                            } else {
                                tmp[node.x][k] = 0;
                            }
                        }
                        //세로처리
                        int sc = (node.x - node.power < 0) ? 0 : node.x - node.power;
                        int ec = (node.x + node.power >= H) ? H - 1 : node.x + node.power;
                        for (int k = sc; k <= ec; k++) {
                            if (tmp[k][node.y] > 1) {
                                q.add(new Node(k, node.y, tmp[k][node.y] - 1));
                                tmp[k][node.y] = 0;
                            } else {
                                tmp[k][node.y] = 0;
                            }
                        }
                    }
                    //내리기
                    for(int l=0; l<W; l++) {
                        int[] line = new int[H];
                        int idx = 0;
                        for (int k = H - 1; k >= 0; k--) {
                            if (tmp[k][l] != 0) {
                                line[idx++] = tmp[k][l];
                            }
                        }
                        idx = 0;
                        for (int k = H - 1; k >= 0; k--) {
                            tmp[k][l] = line[idx++];
                        }
                    }
                    break;
                }
            }
        }

        int count =0;
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(tmp[i][j] != 0){
                    count++;
                    if(count > ans){
                        return;
                    }
                }
            }
        }
        ans = Math.min(count,ans);
    }
}

