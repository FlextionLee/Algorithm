package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ2250_트리의높이와너비 {
    static class Node{
        Node parent;
        int num;
        Node left;
        Node right;
        public Node(int num){
            this.num = num;
        }
    }
    static ArrayList<Node> list;
    static HashMap<Integer,ArrayList<Integer>> map;
    static int[] idx;
    static int ans = 1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        list.add(new Node(0));
        for(int i=1; i<=n; i++){
            list.add(new Node(i));
        }
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(b != -1){
                list.get(a).left = list.get(b);
                list.get(b).parent = list.get(a);
            }
            if(c != -1){
                list.get(a).right = list.get(c);
                list.get(c).parent = list.get(a);
            }
        }
        Node root = null;
        for(Node e : list){
            if(e.parent == null){
                root = e;
            }
        }
        map = new HashMap<>();
        idx = new int[n+1];
        dfs(root.num,1);
        int pos = 0;
        int ans = Integer.MIN_VALUE;

        for(int i : map.keySet()){
            ArrayList<Integer> tmp = map.get(i);
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j : tmp){
                min = Math.min(min,idx[j]);
                max = Math.max(max,idx[j]);
            }
            if(ans < max - min){
                ans = max -min;
                pos = i;
            }
        }
        System.out.println(pos+" "+(ans+1));
    }

    private static void dfs(int i, int bth) {
        if(list.get(i).left != null){
            dfs(list.get(i).left.num,bth+1);
        }
        if(map.containsKey(bth)){
            map.get(bth).add(i);
        }else{
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            map.put(bth,tmp);
        }
        idx[i] = ans++;
        if(list.get(i).right != null){
            dfs(list.get(i).right.num,bth+1);
        }
    }
}
