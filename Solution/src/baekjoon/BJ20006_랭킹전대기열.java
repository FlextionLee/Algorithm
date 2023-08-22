package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ20006_랭킹전대기열 {
    static class Room{
        int level;
        int count;
        ArrayList<User> list;
        public Room(int level, ArrayList<User> list){
            this.level = level;
            this.count = 1;
            this.list = list;
        }
    }
    static class User{
        int level;
        String nickName;
        public User(int level, String nickName){
            this.level = level;
            this.nickName = nickName;
        }
    }
    static ArrayList<Room> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            String nick = st.nextToken();

            User u = new User(val, nick);

            boolean ch = false;
            //룸을 순회하면서 방이 비어있고 해당 방에 입장 가능하다면 입장한다.
            for(Room r : list){
                if(r.count < m){
                    if(r.level-10 <= val && r.level+10 >= val){
                        ch = true;
                        r.count++;
                        r.list.add(u);
                        break;
                    }
                }
            }
            //방에 들어가지 못한 경우
            if(!ch){
                ArrayList<User> nickList = new ArrayList<>();
                nickList.add(u);
                Room r = new Room(val,nickList);
                list.add(r);
            }
        }
        for(Room r : list){
            Collections.sort(r.list,(o1, o2) -> {
                return o1.nickName.compareTo(o2.nickName);
            });
        }
        for(Room r : list){
            if(r.count == m){
                System.out.println("Started!");
                for(User u : r.list){
                    System.out.println(u.level +" "+ u.nickName);
                }
            }else{
                System.out.println("Waiting!");
                for(User u : r.list){
                    System.out.println(u.level +" "+ u.nickName);
                }
            }
        }
    }
}
