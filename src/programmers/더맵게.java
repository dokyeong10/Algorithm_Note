package programmers;

import java.util.*;

public class 더맵게 { //우선 순위 큐
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        while (pq.size() > 1) {
            if (pq.peek() >= K) {
                return answer;
            } else {
                answer++;
                int first = pq.peek();
                pq.remove();
                int sec = pq.peek();
                pq.remove();
                pq.offer(first + (sec * 2));
                if (pq.peek() >= K) {
                    return answer;
                }
            }
        }
        answer = -1;
        return answer;
    }
}
