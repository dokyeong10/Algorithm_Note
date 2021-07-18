package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_18428_감시피하기 {
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int N, map[][], Xnum = 0;
    static int check[][];
    static boolean chk[][];
    private static int[][] commap;
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        commap = new int[N][N];
        StringTokenizer st;
        String ma[][] = new String[N][N];
        check = new int[N][N];
        chk = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                ma[i][j] = st.nextToken();
                if (ma[i][j].equals("X")) {
                    map[i][j] = 0; // 공백
                    Xnum++;

                } else if (ma[i][j].equals("S")) {
                    map[i][j] = 1; //선생님
                } else if (ma[i][j].equals("T")) {
                    map[i][j] = 2; // 학생
                }
            }
        } /////////입력 받기 완료 ///////////
        comb(0);


//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }


    } // end of main

    private static void comb(int num) {
        if (num == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!chk[i][j] && map[i][j] == 0) {
                    map[i][j] = 4; // 장애물
                    chk[i][j] = true;
                    comb(num + 1);

                    map[i][j] = 0;

                    chk[i][j] = false;
                }
            }
        }

    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
} // end of class
