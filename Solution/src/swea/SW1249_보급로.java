//package swea;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.PriorityQueue;
//
//public class SW1249_보급로 {
//        static class Node implements Comparable<Node> {
//            Node(int time, int r, int c){
//                this.time = time;
//                this.r = r;
//                this.c = c;
//            }
//            @Override
//            public int compareTo(Node node) {
//                if(this.time < node.time) {
//                    return -1;
//                }
//                else if(this.time > node.time) {
//                    return 1;
//                }
//                return 0;
//            }
//        }
//    public int time;
//    public int r;
//    public int c;
//        static int n;
//        static String[] graph = new String[100];
//        static int[][] dp = new int[100][100];
//        static int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
//
//        public static void main(String args[]) throws Exception {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int T = Integer.parseInt(br.readLine());
//            for (int t = 1; t <= T; t++) {
//                n =Integer.parseInt(br.readLine());
//
//                for(int i=0; i<n; i++) {
//                    graph[i] = br.readLine();
//                }
//                for(int i=0; i<n ;i++) {
//                    for(int j=0; j<n; j++) {
//                        dp[i][j] = Integer.MAX_VALUE;
//                    }
//                }
//                dp[0][0] = 0;
//
//                dijkstra();
//                System.out.println("#" + t+" " + dp[n-1][n-1]);
//
//            }
//        }
//    static void dijkstra() {
//        PriorityQueue<Node> pq = new PriorityQueue();
//        pq.add(new Node(0,0,0));
//
//        while(!pq.isEmpty()) {
//            Node cur = pq.poll();
//            if(cur.time > dp[cur.r][cur.c]) continue;
//
//            for(int i=0; i< 4; i++) {
//                int nr = cur.r+dir[i][0];
//                int nc = cur.c+dir[i][1];
//                if(nr <0 || nr >=n || nc<0 || nc>=n) continue;
//                int nextTime = cur.time + (int)(graph[nr].charAt(nc)-'0');
//                if(dp[nr][nc]>nextTime) {
//                    dp[nr][nc] = nextTime;
//                    pq.add(new Node(nextTime,nr,nc));
//                }
//            }
//        }
//    }
//    }
//
