package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int left = 0;
        int right = 0;
        for (int test_case = 1; test_case <= T; test_case++) {
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            String s = br.readLine();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(s.charAt(i));
                } else {
                    if (stack.isEmpty()) {
                        flag = true;
                        break;
                    }
                    stack.pop();
                }
            }

            if (flag == true) {
                sb.append("NO").append('\n');
            } else {
                if (stack.isEmpty()) {
                    sb.append("YES").append('\n');
                } else {
                    sb.append("NO").append('\n');
                }
            }


        } // end of tc
        System.out.println(sb);
    } // end of main
} // end of class
