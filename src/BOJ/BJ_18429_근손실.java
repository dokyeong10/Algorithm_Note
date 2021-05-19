package BOJ;

import java.util.Scanner;

/*
 * 문제 접근
 * DFS 사용 , 순열 ( permutaiton ) 다 해보기
 * 3개 = > 3*2*1 => 6가지 다해보기 ㅎ
 *
 * */
public class BJ_18429_근손실 {
    static int N, K, sport[], result = 0;
    static boolean isSelected[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 기간
        K = sc.nextInt(); // 하루마다 떨어지는 근육량
        sport = new int[N]; //운동키트의 중량 증가
        isSelected = new boolean[N]; // 중복 체크

        for (int i = 0; i < N; i++) {
            sport[i] = sc.nextInt();
        } //  입력 받기 완료 /////////

        dfs(0, 0);
        System.out.println(result);

    } // end of main

    static void dfs(int cnt, int weight) {
        if (weight < 0) return; //500이하 즉 음수가 되면 넘김
        if (cnt == N) {
            result++;
            return;
        }

// 순열 코드
        for (int i = 0; i < N; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            dfs(cnt + 1, weight + sport[i] - K);
            isSelected[i] = false;
        }
    }
} // end of class
