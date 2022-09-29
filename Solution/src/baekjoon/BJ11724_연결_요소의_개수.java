package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class BJ11724_연결_요소의_개수 {
    static int N, M, ans;
    static boolean[] visited;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];

        //리스트 배열인데 배열은 몇개인지 위에서 초기화했고
        // 그 안에 담긴 리스트를 초기화하지 않았다.
        //그래서 밑에서 초기화 작업
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        //입력값(간선) 정보를 추가한다.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }

        //각 노드들에 대해서 그 노드가 방문했던 적이 없다면
        //dfs로 연결되어있는 노드들을 찾아보고 카운트를 증가시킴
        for (int i = 1; i <= N; i++) {
            // 방문하지 않은 노드 깊이우선 탐색 후 answer 증가
            if (!visited[i]) {
                ans++;
                //dfs(i);
                bfs(i);
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int i) {

        visited[i] = true;

        for (int j = 0; j < list[i].size(); j++) {
            int v = list[i].get(j);
            if(!visited[v]){
                visited[v] = true;
                dfs(v);
            }
        }
    }

    private static void bfs(int i){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        visited[i] = true;
        while(!q.isEmpty()){
            int tmp = q.poll();

            for(int j:list[tmp]){
                if(!visited[j]){
                    q.add(j);
                    visited[j]=true;
                }
            }
        }
    }
}

