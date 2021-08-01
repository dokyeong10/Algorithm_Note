package programmers;

import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> list = new ArrayList<>();
        int[] rest = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int tmp = 100 - progresses[i];
            int val = tmp / speeds[i];
            int re = tmp % speeds[i];
            if (re > 0) val += 1;
            rest[i] = val;
            System.out.print(rest[i] + " ");
        }
        int cnt = 1;
        int max = rest[0];
        for (int i = 1; i < rest.length; i++) {
            //System.out.println("max= "+ max);
            if (max >= rest[i]) {
                cnt++;
                if (i == rest.length - 1) {
                    list.add(cnt);
                }
            } else if (max < rest[i]) {
                max = rest[i];
                list.add(cnt);
                cnt = 1;
                if (i == rest.length - 1) {
                    list.add(cnt);
                }
            }

        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
