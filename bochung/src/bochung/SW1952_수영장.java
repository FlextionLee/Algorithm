package bochung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1952_수영장 {
	static int T,day,month,three,year,answer;
	static int[] map = new int[12];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			month =Integer.parseInt(st.nextToken());
			three = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<12; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			answer = year;
			dfs(0,0);
			System.out.println("#"+t+" "+answer);
		}
		
	}
	private static void dfs(int depth, int sum) {
		if(depth >= 12) {
//			System.out.println(sum);
			answer = Math.min(answer, sum);
			return;
		}
		
		if(sum >= answer) {
			return;
		}
		
		if(map[depth] != 0) {
			dfs(depth+1 , sum + (map[depth]*day));
			dfs(depth+1, sum + month);
			dfs(depth+3, sum + three);
		}
		else {
			dfs(depth+1, sum);
		}
	}

}
