package programmers;

public class 소수만들기 {
    static boolean check;

    public int solution(int[] nums) {
        int answer = 0;
        check = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum >= 2)
                        check = prime(sum);
                    if (check) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public boolean prime(int sum) {
        check = true;
        if (sum == 2) {
            return check;
        }
        for (int i = 2; i < sum; i++) {
            if (sum % i == 0) {
                check = false;
                break;
            }
        }
        return check;
    }
}
