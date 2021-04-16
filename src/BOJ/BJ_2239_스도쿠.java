package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2239_스도쿠 {
    static int[][] sudo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 9*9 스도쿠
        sudo = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String s = sc.next();
            for (int j = 0; j < 9; j++) {
                sudo[i][j] = s.charAt(j) - '0';
            }
        } //// 입력 받기 완료 //// 

        sudokoo(0, 0);


    } // end of main

    private static void sudokoo(int row, int col) {
        // 열 다채우면 다음행으로 넘어감
        if (col == 9) {
            sudokoo(row + 1, 0);
            return;
        }
        // 행전부다 채우면 스도쿠 전체 출력
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudo[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        if (sudo[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(row, col, i)) {
                    sudo[row][col] = i;
                    sudokoo(row, col + 1);
                }
                // 중복검사 안맞으면
            }
            sudo[row][col] = 0;
            return;
        }
        // 0이 아니면 다음 열로 넘어감
        sudokoo(row, col + 1);


    } // end of Method(sudokoo)

    private static boolean possibility(int row, int col, int value) {
        // 열 겹치는지 검사
        for (int i = 0; i < 9; i++) {
            if (sudo[row][i] == value) {
                return false;
            }
        }
        // 행 겹치는 지 검사
        for (int i = 0; i < 9; i++) {
            if (sudo[i][col] == value) {
                return false;
            }
        }
        //3*3 중복 검사
        int Srow = (row / 3) * 3;
        int Scol = (col / 3) * 3;

        for (int i = Srow; i < Srow + 3; i++) {
            for (int j = Scol; j < Scol + 3; j++) {
                if (sudo[i][j] == value) {
                    return false;
                }
            }
        }


        return true;
    }

} // end of class
