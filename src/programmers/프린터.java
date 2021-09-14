package programmers;

import java.util.*;

public class 프린터 {// 프린터
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int cnt = 1;
        int max = 0;
        Queue<val> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new val(i, priorities[i]));
            max = Math.max(max, priorities[i]);
        }
        while (!q.isEmpty()) {
            val cur = q.poll();
            int loc = cur.loc;
            int val = cur.val;
            if (val != max) {
                q.offer(new val(loc, val));
            } else {
                if (loc == location) {
                    answer = cnt;
                    return answer;
                } else {
                    cnt++;
                    priorities[loc] = 0;
                    max = 0;
                    for (int i = 0; i < priorities.length; i++) {
                        max = Math.max(max, priorities[i]);
                    }
                }
            }
        }
        return answer;
    }

    static class val {
        int loc, val;

        public val(int loc, int val) {
            this.loc = loc;
            this.val = val;
        }
    }
}
