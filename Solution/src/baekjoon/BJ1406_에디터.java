package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ1406_에디터 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Stack<Character> lStack = new Stack<>();
        Stack<Character> rStack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            lStack.push(str.charAt(i));
        }

        for(int i=0; i<n; i++){
            String tmp = br.readLine();
            char command = tmp.charAt(0);
            if(command == 'P'){
                char c = tmp.charAt(2);
                lStack.push(c);
            }else{
                if(command == 'L'){
                    if(!lStack.empty()){
                        rStack.push(lStack.pop());
                    }
                }else if(command=='D'){
                    if(!rStack.isEmpty()){
                        lStack.push(rStack.pop());
                    }
                }else{
                    if(!lStack.empty()){
                        lStack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!lStack.isEmpty()){
            rStack.push(lStack.pop());
        }
        while(!rStack.isEmpty()){
            sb.append(rStack.pop());
        }
        System.out.println(sb);
    }
}
