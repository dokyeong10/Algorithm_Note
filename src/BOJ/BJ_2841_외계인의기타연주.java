package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2841_외계인의기타연주 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //음의 수
        int P = Integer.parseInt(st.nextToken()); // 프렛 수
        int cnt = 0;
        Stack<Integer>[] stack = new Stack[7];
        for (int i = 1; i < 7; i++) {
            stack[i] = new Stack<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sound = Integer.parseInt(st.nextToken());
            int pr = Integer.parseInt(st.nextToken());
            if (stack[sound].isEmpty()) {
                stack[sound].push(pr);
                cnt++;
            }
            if (stack[sound].peek() == pr) continue;
            else if (stack[sound].peek() > pr) {
                while (!stack[sound].isEmpty() && stack[sound].peek() > pr) {
                    stack[sound].pop();
                    cnt++;
                }
            }
            if (!stack[sound].isEmpty() && stack[sound].peek() == pr) continue;
            else {
                stack[sound].push(pr);
                cnt++;
            }
        }
        System.out.println(cnt);
    } // end of main
} // end of class
