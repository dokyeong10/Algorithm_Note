package programmers;

import java.util.*;

public class 메뉴리뉴얼 {
    static HashMap<String, Integer> map;
    static int m;

    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<>();

        // 조합으로 모든 경우의 수 뽑아내기
        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            m = 0; // m은 course[i] 일 때 최대값
            for (int j = 0; j < orders.length; j++) {
                find(0, "", course[i], 0, orders[j]);
            }
            for (String s : map.keySet()) {
                if (map.get(s) == m && m > 1) {
                    pq.offer(s);
                }
            }
        }
        String[] answer = new String[pq.size()];
        int k = 0;
        while (!pq.isEmpty()) {
            answer[k++] = pq.poll();
        }
        return answer;
    }// end of main

    static void find(int cnt, String str, int target, int idx, String word) {
        if (cnt == target) {
            char[] c = str.toCharArray();
            Arrays.sort(c); // 오름차순 정렬
            String temps = "";
            for (int i = 0; i < c.length; i++) {
                temps += c[i];
            }// 다시 문자열로 바꾸기
            map.put(temps, map.getOrDefault(temps, 0) + 1); //getOrDefault : null이면 0으로 default
            m = Math.max(m, map.get(temps)); // 최대값 구하기
            return;
        }
        // 모든 조합 찾기
        for (int i = idx; i < word.length(); i++) {
            char now = word.charAt(i);
            find(cnt + 1, str + now, target, i + 1, word);
        }
    }
}
