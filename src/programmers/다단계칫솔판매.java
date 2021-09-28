package programmers;

import java.util.*;

public class 다단계칫솔판매 { //다단계 칫솔 판매
    static int cnt, max, result;
    static HashMap<String, String> map;
    static HashMap<String, Integer> map2;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        map = new HashMap();
        map2 = new HashMap();
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], referral[i]);
        }
        for (int i = 0; i < enroll.length; i++) {
            map2.put(enroll[i], 0);
        }
        for (int i = 0; i < amount.length; i++) {
            DFS(amount[i] * 100, seller[i]);
        }
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = map2.get(enroll[i]);
        }
        return answer;
    }

    static void DFS(int num, String name) {
        int mon = num / 10 * 10 * 1 / 10; //120원
        int money = num - mon;
        map2.put(name, map2.get(name) + money);
        if (mon < 10 || map.get(name).equals("-")) {
            if (!map.get(name).equals("-")) {
                map2.put(map.get(name), map2.get(map.get(name)) + mon);
            }
            return;
        }
        DFS(mon, map.get(name));
    }
}
