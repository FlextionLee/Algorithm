package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ10799_쇠막대기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int ans = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }else{
                if(s.charAt(i-1) == '('){
                    stack.pop();
                    ans += stack.size();
                }else{
                    stack.pop();
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }
}
