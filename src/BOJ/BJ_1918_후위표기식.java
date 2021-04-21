package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class BJ_1918_후위표기식 {

    static int priori(char ch) { // 기호 우선순위
        if (ch == '(') return 0;
        if (ch == '+' || ch == '-') return 1;
        else return 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sen = sc.next(); // 입력 문자열
        String result = ""; // 정답
        char arr[] = new char[sen.length()];

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sen.length(); i++) {
            arr[i] = sen.charAt(i); // 하나하나 쪼갬
            if ('A' <= arr[i] && 'Z' >= arr[i]) {
                result += arr[i]; //문자면 넣기
            } else if (arr[i] == '(') { // 괄호 열리면
                stack.push(arr[i]); // 스택에 넣기
            } else if (arr[i] == ')') {
                while (!stack.empty()) {
                    char ch = stack.pop();
                    if (ch == '(')
                        break;
                    result += ch;
                }
            } else { // 우선순위에 따라 기호 넣기
                while (!stack.empty() && priori(stack.peek()) >= priori(arr[i])) {
                    result += stack.pop();
                }
                stack.push(arr[i]);

            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        System.out.println(result);
    }// end of main
} // end of class
