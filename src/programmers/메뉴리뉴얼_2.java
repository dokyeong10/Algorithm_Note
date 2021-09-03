package programmers;

import java.util.*;
import java.io.*;

public class 메뉴리뉴얼_2 { //메뉴
    static HashMap<String, Integer> map;
    static int max;

    public String[] solution(String[] orders, int[] course) {

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            max = 0;
            for (int j = 0; j < orders.length; j++) {
                find(0, "", course[i], 0, orders[j]);
            }
            for (String s : map.keySet()) {
                if (map.get(s) == max && max > 1) {
                    list.add(s);
                }
            }
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }//end of main

    static void find(int cnt, String str, int target, int idx, String word) {
        if (cnt == target) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String tmps = "";
            for (int i = 0; i < c.length; i++) {
                tmps += c[i];
            }
            map.put(tmps, map.getOrDefault(tmps, 0) + 1);
            max = Math.max(max, map.get(tmps));
            return;
        }
        for (int i = idx; i < word.length(); i++) {
            char now = word.charAt(i);
            find(cnt + 1, str + now, target, i + 1, word);
        }
    }
}
