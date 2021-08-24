package programmers;

public class A124나라의숫자 {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int num = n;
        while (num != 0) {
            if (num % 3 == 0) {
                sb.insert(0, "4");
                num = num / 3 - 1;
            } else if (num % 3 == 1) {
                sb.insert(0, "1");
                num = num / 3;
            } else if (num % 3 == 2) {
                sb.insert(0, "2");
                num = num / 3;
            }
        }
        answer = sb.toString();
        return answer;
    }
}
