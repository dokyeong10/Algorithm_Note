package BOJ;

import java.util.Scanner;

public class BJ_17070_파이프옮기기 {
    static int N; //집 크기
    static int[][] home; // 집 배열
    static int count; // 파이프 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        home = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                home[i][j] = sc.nextInt();
            }
        } // 입력 받기 완료

        // 첫 파이프 위치가 home[0][0]=0, home[0][1]=1
        // dir 가로 -0, 세로 -1, 대각선 -2

        move(0, 1, 0); //010으로 시작
        System.out.println(count);


    }

    private static void move(int x, int y, int dir) {
        if (x == N - 1 && y == N - 1 && home[x][y] != 1) {
            count++;
            return;
        } // 기저 조건 , N*N위치에 도착하고 파이프 없으면

        // 가로부터 시작
        if (dir == 0) {
            if (isIn(x, y + 1) && home[x][y + 1] == 0) move(x, y + 1, 0); // 가로로

            // 오른쪽 아래 대각선으로 밀때 ( 현재, 오른쪽, 아래 모두 0이어야 가능)
            if (isIn(x + 1, y + 1) && home[x][y + 1] == 0 && home[x + 1][y + 1] == 0 && home[x + 1][y] == 0)
                move(x + 1, y + 1, 2);


        } else if (dir == 1) { // 파이프가 세로 일때
            if (isIn(x + 1, y) && home[x + 1][y] == 0) move(x + 1, y, 1); // 세로로 밀때

            // 오른쪽 아래 대각선으로 밀 때,
            if (isIn(x + 1, y + 1) && home[x][y + 1] == 0 && home[x + 1][y + 1] == 0 && home[x + 1][y] == 0)
                move(x + 1, y + 1, 2);

            // 파이프가 대각선일 때
        } else if (dir == 2) {
            // 가로로 밀때
            if (isIn(x, y + 1) && home[x][y + 1] == 0) move(x, y + 1, 0);
            // 세로로 밀때
            if (isIn(x + 1, y) && home[x + 1][y] == 0) move(x + 1, y, 1);
            // 오른쪽 아래 대각선으로 밀때
            if (isIn(x + 1, y + 1) && home[x][y + 1] == 0 && home[x + 1][y + 1] == 0 && home[x + 1][y] == 0)
                move(x + 1, y + 1, 2);


        }

    }

    // 범위 확인하는 메소드
    private static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
