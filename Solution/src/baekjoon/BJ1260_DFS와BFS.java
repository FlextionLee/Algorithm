package baekjoon;

import java.util.*;
import java.io.*;

public class BJ1260_DFS와BFS {
	static int N,M,V;
	
	static ArrayList<Integer>[] g; 
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		g = new ArrayList[N+1];
		
		for(int i=0; i<N+1; i++) {
			g[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			g[n].add(m);
			g[m].add(n);
		}
		
		for(int i=0; i<g.length; i++) {
			Collections.sort(g[i]);
		}
		
		sb = new StringBuilder();
		dfs(V);
		System.out.println(sb);
		sb = new StringBuilder();
		Arrays.fill(visited, false);
		bfs(V);
		System.out.println(sb);
	}

	private static void bfs(int v) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			sb.append(tmp+" ");
			
			for(int i=0; i<g[tmp].size(); i++) {
				if(!visited[g[tmp].get(i)]) {
					visited[g[tmp].get(i)]=true;
					q.add(g[tmp].get(i));
				}
			}
		}
		
	}

	private static void dfs(int v) {
		visited[v] = true;
		sb.append(v+" ");
		
		for(int i=0; i<g[v].size(); i++){
			if(!visited[g[v].get(i)]) {
				dfs(g[v].get(i));
			}
		}
	}

}
