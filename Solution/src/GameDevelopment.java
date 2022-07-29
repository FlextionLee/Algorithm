import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class GameDevelopment {
	
	static class User{
		int row;
		int col;
		int direction;
		int sight;
		int count=0;
		
		public User(int row,int col,int direction) {
			this.row = row;
			this.col = col;
			this.direction = direction;
		}
	}
	
	//북서남동 으로 델타 선언
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,-1,0,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//지도 배열 선언
		int map[][] =new int[n][m];
		//방문여부 확인 배열 선언
		boolean visited[][] = new boolean[n][m];
		
		st = new StringTokenizer(br.readLine());
		// 행 , 렬 , 초기 방향 입력받기
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());
		
		User user = new User(row,col,direction);
		
		for(int i=0; i<n; i++) {
			 st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	
	}

}
