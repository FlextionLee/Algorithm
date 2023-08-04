package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ11723_집합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> all = new ArrayList<>();
        for(int i=0; i<20; i++){
            all.add(i+1);
        }
        ArrayList<Integer> list= new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            Integer val = null;
            if(!(command.equals("all") || command.equals("empty"))){
                val = Integer.parseInt(st.nextToken());
            }
            switch(command){
                case "add":{
                    if(!list.contains(val)){
                        list.add(val);
                    }
                    break;
                }
                case "remove":{
                    if(list.contains(val)){
                        list.remove(val);
                    }
                    break;
                }
                case "check":{
                    if(list.contains(val)){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;
                }
                case "toggle":{
                    if(list.contains(val)){
                        list.remove(val);
                    }else{
                        list.add(val);
                    }
                    break;
                }
                case "all":{
                    list = new ArrayList<>(all);
                    break;
                }
                case "empty":{
                    ArrayList<Integer> tmp = new ArrayList<>();
                    list = tmp;
                }
            }
        }
        System.out.print(sb.toString());
    }
}
