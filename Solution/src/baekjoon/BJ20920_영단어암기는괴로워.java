package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ20920_영단어암기는괴로워 {
    static class Target{
        String str;
        int freq;
        public Target(String str, int freq){
            this.str = str;
            this.freq = freq;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String ,Integer> map = new HashMap<>();
        ArrayList<Target> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String str = br.readLine();
            map.put(str, map.getOrDefault(str,0)+1);
        }

        for(String s : map.keySet()){
            if(s.length() >= m){
                list.add(new Target(s,map.get(s)));
            }
        }

        Collections.sort(list, (o1, o2)->{
            if(o1.freq == o2.freq){
                if(o1.str.length() == o2.str.length()){
                    return o1.str.compareTo(o2.str);
                }else{
                    return o2.str.length() - o1.str.length();
                }
            }else{
                return o2.freq - o1.freq;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i).str+"\n");
        }
        System.out.println(sb);
    }
}
