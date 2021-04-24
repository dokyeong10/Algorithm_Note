package BOJ;

import java.io.BufferedReader;
import java.util.Scanner;

public class BJ_16987_계란으로계란치기 {
    static int N, answer;
    static Egg[] egg;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 계란 수
        answer = 0;
        egg = new Egg[N];

        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int w = sc.nextInt();
            egg[i] = new Egg(s, w);
        } // 입력 받기 완료

        dfs(0, 0);

        System.out.println(answer);
        sc.close();
    } // end of main

    private static void dfs(int cur, int cnt) {
        if (cur == N) {
            answer = Math.max(answer, cnt);
            return;
        }

        if (egg[cur].hard <= 0) { //현재 들고 있는 계란 내구도가 0이하면
            dfs(cur + 1, cnt);
        } else {
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if (cur == i || egg[i].hard <= 0) continue;

                egg[cur].hard -= egg[i].weight;
                egg[i].hard -= egg[cur].weight;
                flag = true;
                int temp = 0;
                if (egg[cur].hard <= 0) temp++;
                if (egg[i].hard <= 0) temp++;

                dfs(cur + 1, cnt + temp);

                //초기화
                egg[cur].hard += egg[i].weight;
                egg[i].hard += egg[cur].weight;
            }
            if (!flag) dfs(cur + 1, cnt);
        }
    } // end of dfs

    public static class Egg {
        int hard, weight;

        public Egg(int hard, int weight) {
            this.hard = hard;
            this.weight = weight;
        }
    }
}// end of class
