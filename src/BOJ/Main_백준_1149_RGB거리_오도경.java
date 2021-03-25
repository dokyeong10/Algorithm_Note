package BJ;

import java.util.Scanner;

public class Main_백준_1149_RGB거리_오도경 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 집 수
        int map[][] = new int[N][N];



        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = sc.nextInt();
            }
        }  /// 입력 받기 완료 ///
        int result[] = new int[3];
        result[0] = map[0][0];
        result[1] = map[0][1];
        result[2] = map[0][2];
        //초기값 설정

        for (int i = 1; i < N; i++) {
            int R = Math.min(map[i][0] + result[1], map[i][0] + result[2]);
            int G = Math.min(map[i][1] + result[0], map[i][1] + result[2]);
            int B = Math.min(map[i][2] + result[1], map[i][2] + result[0]);

            result[0] = R;
            result[1] = G;
            result[2] = B;


        }
        System.out.println(Math.min((Math.min(result[0], result[1])), result[2]));


    }// end of main


} // end of class
