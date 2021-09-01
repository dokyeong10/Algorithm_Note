package programmers;

import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
        int one[] = {1, 2, 3, 4, 5};
        int two[] = {2, 1, 2, 3, 2, 4, 2, 5};
        int three[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int test[] = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % 5]) test[0]++;
            if (answers[i] == two[i % 8]) test[1]++;
            if (answers[i] == three[i % 10]) test[2]++;
        }
        int max = -1;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, test[i]);
        }
        for (int i = 0; i < 3; i++) {
            if (test[i] == max) {
                list.add(i + 1);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
