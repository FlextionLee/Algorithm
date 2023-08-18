package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ3758_KCPC {
    static class Team{
        int id, count,last;
        int[] scores;
        int lastScore;
        public Team(int id,int[] scores){
            this.id = id;
            this.scores = scores;
        }
        public void getLast(){
            for(int i=0; i<scores.length; i++){
                lastScore += scores[i];
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int id = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            ArrayList<Team> teams = new ArrayList<>();
            teams.add(new Team(0,new int[k+1]));
            for(int i=1; i<=n; i++){
                teams.add(new Team(i,new int[k+1]));
            }
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int id2 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                int sco = Integer.parseInt(st.nextToken());
                Team team = teams.get(id2);
                if(team.scores[num2] < sco){
                    team.scores[num2] = sco;
                    team.count++;
                    team.last = i;
                }else{
                    team.count++;
                    team.last = i;
                }
            }

            for(int i=1; i<=n; i++){
                teams.get(i).getLast();
            }

            Collections.sort(teams,(o1,o2)->{
                if(o2.lastScore == o1.lastScore){
                    if(o2.count == o1.count){
                        return o1.last - o2.last;
                    }else{
                        return o1.count - o2.count;
                    }
                }else{
                    return o2.lastScore - o1.lastScore;
                }
            });
            int count = 1;
            for(Team team:teams){
                if(team.id == id){
                    System.out.println(count);
                    break;
                }
                count++;
            }

        }
    }
}
