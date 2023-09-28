package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ5639_이진검색트리 {
    static class Node{
        int num;
        Node left,right;
        public Node(int num){
            this.num = num;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));

        while(true){
            String str = br.readLine();
            if(str == null || str.equals("")) break;
            Node next = new Node(Integer.parseInt(str));
            insert(root,next);
        }
        postorder(root);
    }
    public static void postorder(Node root){
        if(root.left != null){
            postorder(root.left);
        }
        if(root.right != null){
            postorder(root.right);
        }
        System.out.println(root.num);
    }
    public static void insert(Node root, Node next){
        if(root.num < next.num){
            if(root.right == null){
                root.right = next;
            }else{
                insert(root.right,next);
            }
        }else{
            if(root.left == null){
                root.left = next;
            }else{
                insert(root.left,next);
            }
        }
    }
}
