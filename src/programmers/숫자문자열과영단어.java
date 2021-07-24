package programmers;

import java.util.*;

public class 숫자문자열과영단어 {
    public int solution(String s) {
        int answer = 0;
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                tmp += s.charAt(i);
            } else if (s.length() > i + 3 && s.substring(i, i + 4).equals("zero")) {
                tmp += '0';
                i += 3;
            } else if (s.length() > i + 2 && s.substring(i, i + 3).equals("one")) {
                tmp += '1';
                i += 2;
            } else if (s.length() > i + 2 && s.substring(i, i + 3).equals("two")) {
                tmp += '2';
                i += 2;
            } else if (s.length() > i + 4 && s.substring(i, i + 5).equals("three")) {
                tmp += '3';
                i += 4;
            } else if (s.length() > i + 3 && s.substring(i, i + 4).equals("four")) {
                tmp += '4';
                i += 3;
            } else if (s.length() > i + 3 && s.substring(i, i + 4).equals("five")) {
                tmp += '5';
                i += 3;
            } else if (s.length() > i + 2 && s.substring(i, i + 3).equals("six")) {
                tmp += '6';
                i += 2;
            } else if (s.length() > i + 4 && s.substring(i, i + 5).equals("seven")) {
                tmp += '7';
                i += 4;
            } else if (s.length() > i + 4 && s.substring(i, i + 5).equals("eight")) {
                tmp += '8';
                i += 4;
            } else if (s.length() > i + 3 && s.substring(i, i + 4).equals("nine")) {
                tmp += '9';
                i += 3;
            }
        }
        answer = Integer.valueOf(tmp);
        return answer;
    }
}
