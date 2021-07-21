package programmers;

import java.util.*;

public class 괄호회전하기 {
    public int solution(String s) {
        int answer = -1;
        int result = 0;
        String tmp = "";

        for (int k = 0; k < s.length(); k++) {
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                    stack.push(s.charAt(i));
                } else if (s.charAt(i) == ']') {
                    if (stack.isEmpty()) {
                        flag = true;
                        break;
                    }
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        break;
                    }
                } else if (s.charAt(i) == '}') {
                    if (stack.isEmpty()) {
                        flag = true;
                        break;
                    }
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        break;
                    }
                } else if (s.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        flag = true;
                        break;
                    }
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
            if (stack.isEmpty() && !flag) {
                result++;
            }
            for (int j = 0; j < s.length(); j++) {
                tmp += s.charAt((j + 1) % s.length());
            }
            s = tmp;
            tmp = "";
        }
        return result;
    }
}
