import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
    public class  SwitchOnAndOff {

        //스위치를 키고 끄는 함수를 만들기 위해 스태틱 불린 배열 선언
        static boolean[] switches;

        //스위치 키고 끄기 함수
        private static void OnOff(int gender, int sNum) {
            //남학생인 경우
            if (gender == 1) {
                for (int i = 1; i < switches.length; i++) {
                    //i가 받은 수의 배수라면
                    if (i % sNum == 0) {
                        //1과 xor 연산을 하여 1->0 0->1로 바꿔줌
                        switches[i] ^= true;
                    }
                }
            }
            //여학생인 경우
            else {
                //무조건 받은 수 는 바꿔줌
                switches[sNum] ^= true;
                //왼쪽으로만 이동하는 포인터, 오른쪽으로만 이동하는 포인터에 받은수(인덱스)를 담음
                int lt = sNum;
                int rt = sNum;

                while (true) {
                    //배열 범위를 넘어가면 멈춤
                    if (lt < 1 || rt >= switches.length) {
                        break;
                    }
                    //데칼코마니가 안돼면 멈춤
                    if (switches[lt] != switches[rt]) {
                        break;
                    }
                    //둘다 아니라면 값을 바꿔주고 lt는 왼쪽으로 rt는 오른쪽으로 증가
                    switches[lt] ^= true;
                    switches[rt] ^= true;
                    lt--;
                    rt++;
                }
            }

        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            //스위치 초기 상태 인덱스 관리 용이함 +1 해줌
            switches = new boolean[n + 1];

            //1이면 true 넣고, 0이면 false 넣기
            for (int i = 1; i < switches.length; i++) {
                switches[i] = st.nextToken().charAt(0) == '1';
            }
            //학생 수 받기
            int student = Integer.parseInt(br.readLine());
            //정보 받아서 성별, 받은 수 나눠서 push함수에 넣기
            for (int i = 0; i < student; i++) {
                st = new StringTokenizer(br.readLine());
                int gender = Integer.parseInt(st.nextToken());
                int sNum = Integer.parseInt(st.nextToken());
                OnOff(gender, sNum);
            }
            // 출력
            for (int i = 1; i < switches.length; i++) {
                if (switches[i]) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
                if (i % 20 == 0) {
                    System.out.println();
                }
            }
        }
    }



