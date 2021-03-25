package SWEA;

import java.util.Scanner;
import java.util.Stack;

/*
 * Stack : LIFO(Last In First Out)
 * 
 * 
 * */
public class Solution_SWEA_1218_괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] c = { { '(', ')' }, { '{', '}' }, { '[', ']' }, { '<', '>' } };

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt(); // n글자의 길이
			String s = sc.next();// 괄호 문자열
			Stack<Character> stack = new Stack<Character>();// 스택객체생성
			int result = 1; // 유효성 여부 저장

			ex: for (int i = 0; i < s.length(); i++) { // 문자열 길이만큼 반복 //ex는 라벨
				for (int j = 0; j < 4; j++) {
					if (s.charAt(i) == c[j][0]) {// 열린 괄호: 스택에 넣기
						stack.push(s.charAt(i));
						break;
					} else if (s.charAt(i) == c[j][1]) {// 닫힌 괄호 : 스텍에서 열린괄호 꺼내서 내짝꿍이 맞는지 체크
						char x = stack.pop();
						if (x != c[j][0]) { // 내 짝궁이 맞는지 체크
							result = 0;
							break ex;
						}
					}
				}
			}
			if (!stack.isEmpty()) {// 스택이 비어있어야 올바른 문장
				result = 0;

			}
			System.out.println("#" + test_case + " " + result);
		} // end of tc
		/*
		 * Stack<Character> stack = new Stack<Character>();//스택객체생성 stack.push('(');
		 * stack.push('{'); stack.push('['); System.out.println(stack.size());//스택 안 크기
		 * System.out.println(stack.pop()); // 스택의 꼭대기에 있는 데이터 (가장마지막에 넣은 데이터) 꺼내기
		 * System.out.println(stack.pop()); // 스택의 꼭대기에 있는 데이터 (가장마지막에 넣은 데이터) 꺼내기
		 * System.out.println(stack.pop()); // 스택의 꼭대기에 있는 데이터 (가장마지막에 넣은 데이터) 꺼내기
		 * System.out.println(stack.isEmpty()); //비어있는지 확인 - 다꺼내서 트루임
		 * System.out.println(stack.size()); //스택 크기
		 */
	}// end of main
}// end of calss
