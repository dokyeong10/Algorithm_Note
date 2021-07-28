package programmers;

import java.util.*;

public class 타겟넘버 {
    static int cnt, result;

    public int solution(int[] numbers, int target) {
        int answer = 0;
        result = target;
        dfs(0, 0, numbers);
        answer = cnt;
        return answer;
    }

    static void dfs(int num, int sum, int numbers[]) {
        if (num == numbers.length) {
            if (sum == result) {
                cnt++;
            }
            return;
        }
        dfs(num + 1, sum + numbers[num], numbers);
        dfs(num + 1, sum - numbers[num], numbers);
    }
}
