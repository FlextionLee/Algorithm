import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1018_체스판_다시_칠하기 {
	
/*	지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 
 *  M×N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 
 *  나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
 *  체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 
 *  구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.
 *  따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
	보드가 체스판처럼 칠해져 있다는 보장이 없어서,
	지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
	당연히 8*8 크기는 아무데서나 골라도 된다.
	 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
*/
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int answer = Integer.MAX_VALUE;
		
		//0,0이 흰색인 배열 미리 생성
		char[][] wMap = new char[8][8];
		char[] even = {'W','B','W','B','W','B','W','B'};
		char[] odd = {'B','W','B','W','B','W','B','W'};

		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(i%2 == 0) {
					wMap[i] = even;
				}
				else {
					wMap[i] = odd;
				}
			}
		}
		
		//입력 받을 배열 생성
		char[][] map = new char[n][m];
		
		//입력 받기
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0 ;j<m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		//배열을 벗어나지 않게 돌기
		for(int i=0; i<=n-8; i++) {
			for(int j=0; j<=m-8; j++) {
				
				int count = 0;
				//탐색 
				for(int x=i,r=0; x<i+8; x++,r++) {
					for(int y=j,c=0; y<j+8; y++,c++) {
						if(map[x][y] != wMap[r][c]) {
							count++;
						}
					}
				}
				//검정색 시작인 배열을 바꾸는 갯수 = 64-흰색이 시작인 배열로 바꾸는 갯수
				//둘 중 작은걸 비교해서 min에 넣기
				int min = (64-count > count)?count:64-count;
				answer = Math.min(answer, min);
			}
		}
		System.out.println(answer);
	}

}
