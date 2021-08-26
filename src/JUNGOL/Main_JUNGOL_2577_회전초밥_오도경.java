package JUNGOL;


import java.util.Scanner;


public class Main_JUNGOL_2577_회전초밥_오도경 {
    static int N, d, k, c, sushi[], table[], maxCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        d = sc.nextInt();
        k = sc.nextInt();
        c = sc.nextInt();

        table = new int[N]; // 입력받는 초밥   8개
        sushi = new int[d + 1]; // 초밥 종류  30가지

        for (int i = 0; i < N; i++) {
            table[i] = sc.nextInt();
        } /// / 접시 순서대로 입력 받기 완료 / / / /

        maxCnt = 0; // 최댓값

        start();

        System.out.println(maxCnt);
        sc.close();
    }
    private static void start() {
        int eat = 0; // 먹었을 때 카운트

        // 일단 k개 만큼 먹는다.
        for (int i = 0; i < k; i++) {
            if (sushi[table[i]]++ == 0) { // 초밥 [테이블에 있는 종류] +1
                eat++; // 먹음
            }
        }

        // 쿠폰 초밥 먹었는지 확인.
        if (sushi[c] == 0) eat++; // 쿠폰 종류 초밥 먹은 적 없으면 먹고+1
        maxCnt = Math.max(eat, maxCnt); // 최대치 갱신
        if (sushi[c] == 0) eat--; // 가장 앞의 초밥을 안먹은 거로 치고
        // 추가추가 하며 갈 것이므로 먹은거 -1

        int idx = 0; // 가장 앞을 가리킬 인덱스
        for (int i = 1; i < N; i++) { // 가장 앞 바로 다음 초밥부터
            if (--sushi[table[idx]] == 0) { // 초밥[먹었던 가장 앞의 테이블위 종류] -1
                eat--; // 다시 안먹은걸로
            }

            // 원형처럼 연결이 되어있기 때문에 %N으로 나누어주어야한다. N을 벗어나면 가장 앞을 선택.
            if (sushi[table[(i + k - 1) % N]]++ == 0) {
                eat++;
            }

            if (sushi[c] == 0) eat++;
            maxCnt = Math.max(eat, maxCnt);
            if (sushi[c] == 0) eat--;

            idx++;
        }
    }
} // end of class
