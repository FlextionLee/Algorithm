package studygroup.Week029;

public class perm {
    static int[] arr = {1,2,3,4};
    static boolean[] visited;
    static int[] tmp ;

    public static void main(String[] args) {
        visited = new boolean[4];
        tmp = new  int[4];
        dfs(0);
    }

    private static void dfs(int depth) {
        if(depth == 4){
            for(int i=0; i<4; i++){
                System.out.print(tmp[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<4; i++){
            tmp[depth] = arr[i];
            dfs(depth+1);
        }
    }
}
