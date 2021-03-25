package SWEA;

import java.util.*;

public class Solution_SWEA_1223_계산기2_오도경 {

	public static int get_prior(char c) { // 우선순위 설정
		if (c == '*')
			return 1;
		else if (c == '+')
			return 3;
		else
			return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt(); // 테스트케이스 길이
			String s = sc.next(); // 부호
			Stack<Character> oper = new Stack<Character>();
			String r = ""; // r에 식을 넣는다.
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i); // 문자를 숫자로 바꾼다. 
				if (c - '0' >= 0 && c - '0' <= 9) { // 숫자가 0~9 사이의 범위에 있다면
					r += String.valueOf(c); // 바로 출력
				} else {// 부호라면
					if (oper.isEmpty()) { // 스택이 비었으면 넣는다.
						oper.push(c);
					} else { // 이미 다른 부호가 있을경우
						if (get_prior(oper.peek()) <= get_prior(c)) { // 우선순위를 따짐. *가 더 우선순위 높다.
							r += String.valueOf(oper.pop()); // 우선순위 같거나 낮을 경우 이미 있는거 빼고 넣는다.
							oper.push(c);
						} else {
							oper.push(c);// 우선순위 높으면 푸쉬
						}
					}
				}
			}
			while (!oper.isEmpty()) {
				r += String.valueOf(oper.pop()); // 내용모두 출력
			}

			Stack<Integer> nums = new Stack<Integer>(); // 계산 스택
			for (int i = 0; i < r.length(); i++) {// 범위
				char c = r.charAt(i); // 문자열을 숫자로 바꾼다.
				if (c - '0' >= 0 && c - '9' <= 0) // 0~9안에 범위에 있는가?
					nums.push(c - '0'); // 있으면 push
				else {
					int tmp1 = nums.pop(); // 숫자 두개 빼고
					int tmp2 = nums.pop();
					if (c == '*') // *이면 둘이 곱 넣기
						nums.push(tmp1 * tmp2);
					else if (c == '+') // +면 둘이 더해서 스택에 넣기
						nums.push(tmp1 + tmp2);
				}
			}
			System.out.println("#" + test_case + " " + nums.pop()); // 출력
		} // end of tc
	}// end of main
}// end of class
