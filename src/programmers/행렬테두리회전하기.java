package programmers;

import java.util.*;

public class 행렬테두리회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int map[][] = new int[rows][columns];
        int remap[][] = new int[rows][columns];
        int tmp = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = tmp;
                remap[i][j] = tmp;
                tmp++;
            }
        } // 배열에 숫자 채우기

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            int min = Integer.MAX_VALUE;
            for (int j = x1; j < x2 + 1; j++) {
                for (int k = y1; k < y2 + 1; k++) {
                    if (j == x1 && k != y2) {
                        map[j][k + 1] = remap[j][k];
                        min = Math.min(min, remap[j][k]);
                    } else if (k == y2 && j != x2) {
                        map[j + 1][k] = remap[j][k];
                        min = Math.min(min, remap[j][k]);
                    } else if (j == x2 && k != y1) {
                        map[j][k - 1] = remap[j][k];
                        min = Math.min(min, remap[j][k]);
                    } else if (k == y1 && j != x1) {
                        map[j - 1][k] = remap[j][k];
                        min = Math.min(min, remap[j][k]);
                    }
                }
            }
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    remap[j][k] = map[j][k];
                }
            }
            answer[i] = min;
        }
        return answer;
    }
}
