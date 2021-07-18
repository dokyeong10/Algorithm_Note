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
    static int N, map[][];
    static boolean chk[][];
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        chk = new boolean[N][N];
        StringTokenizer st;
        String ma[][] = new String[N][N];
        flag = false;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                ma[i][j] = st.nextToken();
                if (ma[i][j].equals("X")) {
                    map[i][j] = 0; // 공백
                } else if (ma[i][j].equals("S")) {
                    map[i][j] = 1; //선생님
                } else if (ma[i][j].equals("T")) {
                    map[i][j] = 2; // 학생
                }
            }
        } /////////입력 받기 완료 ///////////
        comb(0);
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    } // end of main

    private static void comb(int num) {
        int tmp = 1;
        int cnt = 0;
        if (num == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) {
                        tmp = 1;
                        for (int d = 0; d < 4; d++) {
                            tmp = 1;
                            while (true) {
                                int nr = i + dr[d] * tmp;
                                int nc = j + dc[d] * tmp;
                                if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1) break;
                                if (map[nr][nc] == 2) {
                                    cnt++;
                                    break;
                                } else if (map[nr][nc] == 4) {
                                    break;
                                } else if (map[nr][nc] == 1) {
                                    break;
                                } else if (map[nr][nc] == 0) {
                                    tmp++;
                                }
                            }
                        }

                    }
                }
            }
            if (cnt == 0) {
                flag = true;
            }
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
} // end of class
