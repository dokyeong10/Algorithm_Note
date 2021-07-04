package BOJ;

import java.util.*;
import java.io.*;

public class BJ_9935_문자열폭발 {
    // stack 사용
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<Character>();
        boolean flag = false;

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            if (stack.size() >= bomb.length()) {
                flag = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");


    } // end of main
} // end of class