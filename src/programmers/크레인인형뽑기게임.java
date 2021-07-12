package programmers;

import java.util.*;
import java.io.*;

public class 크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0; // 최종 답
        int cnt = 0; // 사라지는 숫자 카운트
        Stack<Integer> stack = new Stack();
        int len = moves.length;
        int k = 0;
        while (len-- > 0) { // moves 배열 크기만큼 돌아줌
            int tmp = moves[k] - 1; //1부터 시작하므로 -1 해줌
            k++;
            for (int i = 0; i < board.length; i++) {
                if (board[i][tmp] == 0) { // 0이면 컨티뉴
                    continue;
                } else {
                    if (stack.size() >= 1 && board[i][tmp] == stack.peek()) { // 제일 위와 비교했을 때 같으면
                        stack.pop();
                        board[i][tmp] = 0; //0으로 바꿔줌
                        cnt += 2; // 카운트 +2
                        break;
                    } else { // 아니면 스택에 쌓기
                        stack.push(board[i][tmp]);
                        board[i][tmp] = 0;
                        break;
                    }
                }
            }
        }
        // System.out.println(cnt);
        answer = cnt;
        return answer;
    }
}
