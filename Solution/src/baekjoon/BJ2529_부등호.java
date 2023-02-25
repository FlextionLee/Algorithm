package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ2529_부등호 {

    static int k;
    static char[] signs;
    static int[] tgt;
    static boolean[] isSelected;

    static ArrayList<String> ans = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        signs = new char[k];
        tgt = new int[k+1];
        isSelected = new boolean[10];

        // input sign of inequalities
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) signs[i] = st.nextToken().charAt(0);

        // permutation
        perm(0);

        // sort & print
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder(ans.get(ans.size()-1)+"\n"+ans.get(0));
        System.out.println(sb);

    }

    static void perm(int idx) {
        // 기저조건
        if(idx == tgt.length) {
            ans.add(makeNum());
            return;
        }

        for(int i=0; i<10; i++) {
            if(isSelected[i]) continue;

            // 부등호 판별
            if(idx>0 && !checkSign(idx, i))    continue;

            isSelected[i] = true;
            tgt[idx] = i;
            perm(idx+1);
            isSelected[i] = false;
        }
    }

    static boolean checkSign(int idx, int num) {
        if(signs[idx-1]=='<') return tgt[idx-1] < num;
        else return tgt[idx-1] > num;
    }

    static String makeNum() {
        StringBuilder tmp = new StringBuilder();

        for(int i=0; i<tgt.length; i++) {
            tmp.append(tgt[i]);
        }

        return tmp.toString();
    }
}

