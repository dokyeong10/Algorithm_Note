package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_2504_괄호의값_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sen = br.readLine();
        Stack<String> stack = new Stack<>();
        int a = 0, b = 0;
        for (int i = 0; i < sen.length(); i++) {
            switch (sen.charAt(i)) {
                case '(':
                    a++;
                    stack.push("(");
                    break;

                case '[':
                    b++;
                    stack.push("[");
                    break;

                case ')':
                    a--;
                    if (a >= 0) {
                        if (stack.peek() == "(") {
                            stack.pop();
                            stack.push("2");
                            break;
                        } else {
                            int Cresult = 0;
                            while (!stack.isEmpty()) {
                                if (stack.peek() == "[") {
                                    System.out.println(0);
                                    return;
                                } else if (stack.peek() == "(") {
                                    stack.pop();
                                    Cresult *= 2;
                                    stack.push(String.valueOf(Cresult));
                                    break;
                                } else {
                                    Cresult += Integer.parseInt(stack.pop());
                                }
                            }
                        }
                    }
                    break;

                case ']':
                    b--;
                    if (b >= 0) {
                        if (stack.peek() == "[") {
                            stack.pop();
                            stack.push("3");
                            break;
                        } else {
                            int Sresult = 0;
                            while (!stack.isEmpty()) {
                                if (stack.peek() == "(") {
                                    System.out.println(0);
                                    return;
                                } else if (stack.peek() == "[") {
                                    stack.pop();
                                    Sresult *= 3;
                                    stack.push(String.valueOf(Sresult));
                                    break;
                                } else {
                                    Sresult += Integer.parseInt(stack.pop());
                                }
                            }
                        }
                    }
                    break;
            }// switch
        }// end of for
        if (a != 0 || b != 0) {
            System.out.println(0);
            return;
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += Integer.parseInt(stack.pop());
        }
        System.out.println(result);


    } // end of main
} // end of class
