package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1074_Z {
	static int N,R,C;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N  = Integer.parseInt(st.nextToken());
		R  = Integer.parseInt(st.nextToken());
		C  = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, N);
		
		dfs(0,0,N,0);
	}
	public static void dfs(int x, int y, int size,int count) {
		if(size == 1) {
			if(R == x && C == y) {
				System.out.println(count);
			}
			count++;
			return;
		}
		
		int half = size / 2;
		
        if(x<=R && R<x+half && y<=C && C<y+half){
            dfs(x, y, half, count);
        }else if(x<=R && R<x+half && y+half<=C && C<y+size){
            dfs(x, y+half, half, count+half*half);
        }else if(x+half<=R && R<x+size && y<=C && C<y+half){
            dfs(x+half, y, half, count+half*half*2);
        }else{
            dfs(x+half, y+half, half, count+half*half*3);
        }
	}

}
