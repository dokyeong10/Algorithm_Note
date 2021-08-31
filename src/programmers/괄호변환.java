package programmers;

import java.util.*;

public class 괄호변환 {
    public String solution(String p) {
        String answer = " ";
        String sen = p; // 복사본
        StringBuilder ans = new StringBuilder();
        while (ans.length() < p.length()) {
            StringBuilder u = new StringBuilder();
            StringBuilder v = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            int open = 0;
            int close = 0;

            for (int i = 0; i < sen.length(); i++) {
                if (open > 0 && close > 0 && open == close) {
                    v.append(sen.charAt(i));
                } else {
                    u.append(sen.charAt(i));
                    if (sen.charAt(i) == '(') {
                        open++;
                    } else {
                        close++;
                    }
                }
            } // u와 v 나누기 완료

            // System.out.println("u: " + u);
            // System.out.println("v: " + v);

            for (int i = 0; i < u.length(); i++) {
                if (!stack.isEmpty() && stack.peek() == '(' && u.charAt(i) == ')') {
                    stack.pop();
                } else {
                    stack.push(u.charAt(i));
                }
            } // 올바른 문자열인지 판별

            if (stack.isEmpty()) { // 올바른 문자열
                return u.append(solution(v.toString())).toString();
                //System.out.println("ans;"+ans);
            }
            ans.append("(").append(solution(v.toString())).append(")"); // 4-2 재귀 돌기

            u.deleteCharAt(0); // 4-4  u 맨앞 , 맨뒤 삭제
            u.deleteCharAt(u.length() - 1);
            for (int j = 0; j < u.length(); j++) { // u의 문자열 뒤집기
                char tmp = u.charAt(j);
                if (tmp == '(') {
                    u.setCharAt(j, ')');
                } else {
                    u.setCharAt(j, '(');
                }
            }
            ans.append(u); // 답에 붙이기
        }
        answer = ans.toString();
        return answer;
    }
}
