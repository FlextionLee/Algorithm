//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.Queue;
//
//public class test {
//    static class Tower{
//        int index;
//        boolean control;
//        int height;
//        public Tower(){};
//        public Tower(int index, int height, boolean control){
//            this.index = index;
//            this.height = height;
//            this.control = control;
//        }
//    }
//
//    /**
//     * 높이가 서로 다른 타워 N개가 존재한다. 각 타워의 높이는 상대적으로 표현되어 높이가 작은 순서대로 1부터 N까지의 수로 나타내어 주어진다.
//     *
//     * 처음 모든 타워는 일반 타워
//     *
//     * 지만 통신 장비 강화를 통해
//     * 컨트롤 타워로 업그레이드시켜줄 수 있다.
//     *
//     * 컨트롤 타워는 외부의 정보를 수신받는 역할로, 모든 컨트롤 타워에 동시에 정보가 도달한다.
//     * 반면에, 일반 타워는 외부의 정보를 바로 수신받을 수 없고,
//     * 그 타워가 가진 높이보다 높으면서 가장 가까운 타워에서 1시간에 걸쳐서 정보를 받아오는 게 정보를 얻는 유일한 방법이다.
//     * 만약 정보를 받아 올 수 있는 타워가 여러 개 존재한다면 가장 왼쪽에 있는 타워를 선택하고,
//     * 존재하지 않는다면 받을 수 없으므로 높이가 N인 타워가 일반 타워일 경우 정보를 받아올 방법이 없다.
//     *
//     * 모든 타워에 외부 정보가 퍼지는 데 너무 오랜 시간이 걸리면 문제가 발생할 수 있으므로
//     * K시간보다 더한 시간이 걸려서 정보를 얻는 타워가 없도록 일부 타워를 컨트롤 타워로 업그레이드시켜주려고 한다.
//     * 모든 타워를 컨트롤 타워로 업그레이드한다면 좋겠지만, 통신 장비를 강화하는 데 드는 비용이 적지 않기 때문에 최소 개수의 타워만을 선택하여 강화하기로 했다.
//     * 강화해야 하는 타워의 개수를 구해보자.
//     * @param args
//     */
//    public static void main(String[] args) {
//        int n = 6;
//        int k =2;
//        int[] h = {1,3,5,4,2,6};
//        solution(n,k,h);
//    }
//    static ArrayList<Tower> towerList;
//    static  int N;
//    public static int solution(int n, int k, int[] h){
//        int answer = 0;
//        N = n;
//        Tower tower = new Tower();
//        towerList = new ArrayList<>();
//        int max = Integer.MIN_VALUE;
//        int idx = 0;
//        int minArr[] = new int[h.length];
//        int min = Integer.MAX_VALUE;
//        for(int i=0; i<h.length; i++){
//            if(max < h[i]){
//                max = h[i];
//                idx = i;
//            }
//            if(min > h[i]){
//                minArr[i] = h[i];
//                min = h[i];
//            }else{
//                minArr[i] = minArr[i-1];
//            }
//        }
//        tower.index = idx;
//        tower.height = max;
//
//        for(int i=0; i<h.length; i++){
//            System.out.println(minArr[i]);
//        }
//        while(true){
//            if(bfs(towerList)){
//                break;
//            }
//        }
//
//        return answer;
//    }
//
//    private static void bfs(ArrayList<Tower> towerList) {
//        Queue<Tower> q = new ArrayDeque<>();
//        boolean[] visited = new boolean[N];
//        for(Tower tower : towerList){
//            q.add(tower);
//            visited[tower.index] = true;
//        }
//
//        while(!q.isEmpty()){
//            Tower tmp = q.poll();
//
//        }
//    }
//}
