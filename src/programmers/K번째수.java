package programmers;

import java.util.*;

public class K번째수 { //k번째 수 ㅎㅎ
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int num = commands[i][2];
            int tmp[] = new int[end - start + 1];
            int k = 0;
            for (int j = start; j <= end; j++) {
                tmp[k] = array[j];
                k++;
            }
            Arrays.sort(tmp);
            answer[i] = tmp[num - 1];
        }
        return answer;
    }
}
