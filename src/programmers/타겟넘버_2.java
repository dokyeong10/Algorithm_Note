package programmers;

public class 타겟넘버_2 {
    static int cnt, result;

    public int solution(int[] numbers, int target) {
        int answer = 0;
        result = target;
        DFS(0, 0, numbers);
        answer = cnt;
        return answer;
    }

    static public void DFS(int idx, int sum, int numbers[]) {
        if (idx == numbers.length) {
            if (sum == result) {
                cnt++;
            }
            return;
        }
        DFS(idx + 1, sum + numbers[idx], numbers);
        DFS(idx + 1, sum - numbers[idx], numbers);

    }
}
