package baekjoon;
import java.util.*;
public class PG_방금그곡 {
        static class Info{
            String name;
            int len;
            int idx;
            public Info(String name, int len, int idx){
                this.name = name;
                this.len = len;
                this.idx = idx;
            }
        }
        public String solution(String m, String[] musicinfos) {
            ArrayList<Info> list = new ArrayList<>();
            loop:
            for(int i=0; i<musicinfos.length; i++){
                String[] tmp = musicinfos[i].split(",");
                String start = tmp[0];
                String end = tmp[1];
                String name = tmp[2];
                String melody = tmp[3];

                int len = getLen(start, end);

                ArrayList<String> candi = new ArrayList<>();
                ArrayList<String> hear = new ArrayList<>();
                int l = 0;
                while(true){
                    if(candi.size() == len){
                        break;
                    }
                    int mod = l%melody.length();
                    if(melody.charAt((mod+1)%melody.length()) == '#'){
                        candi.add((String.valueOf(melody.charAt(mod)) + String.valueOf(melody.charAt((mod+1)%melody.length()))));
                        l++;
                    }else{
                        candi.add((String.valueOf(melody.charAt(mod))));
                    }
                    l++;
                }
                for(int j=0; j<m.length(); j++){
                    if(j!=m.length()-1){
                        if(m.charAt(j+1)=='#'){
                            hear.add(String.valueOf(m.charAt(j)) + String.valueOf(m.charAt(j+1)));
                            j++;
                        }else{
                            hear.add(String.valueOf(m.charAt(j)));
                        }
                    }else{
                        hear.add(String.valueOf(m.charAt(j)));
                    }
                }
                if(hear.size() > candi.size()) continue;

                String compare = "";
                for(int j=0; j<hear.size(); j++){
                    compare += candi.get(j);
                }
                if(m.equals(compare)){
                    list.add(new Info(name,len,i));
                    continue;
                }

                for(int j= hear.size(); j<candi.size(); j++){
                    compare += candi.get(j);
                    if(compare.charAt(1) == '#'){
                        compare = compare.substring(2);
                    }else{
                        compare = compare.substring(1);
                    }
                    if(compare.equals(m)){
                        list.add(new Info(name,len,i));
                        continue loop;
                    }
                }
            }
            Collections.sort(list,(o1,o2)->{
                if(o1.len == o2.len){
                    return o1.idx - o2.idx;
                }else{
                    return o2.len - o1.len;
                }
            });
            if(list.size() == 0){
                return "(None)";
            }else{
                return list.get(0).name;
            }
        }
        public static int getLen(String s, String e){
            String[] start = s.split(":");
            String[] end = e.split(":");
            int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
            int a = Integer.parseInt(start[1]);
            int b = Integer.parseInt(end[1]);
            if(a>b){
                b+=60;
                hour--;
            }
            b -= a;
            return hour*60+b;
        }
    }
}
