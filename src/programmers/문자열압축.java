package programmers;

public class 문자열압축 {
    public int solution(String s) {
        StringBuilder sb;
        int answer = 0;
        int min = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (j + i > s.length()) break;
                String a = s.substring(j, j + i);
                int cnt = 1;

                for (int k = j + i; k < s.length(); k += i) {
                    if (k + i <= s.length() && a.equals(s.substring(k, k + i))) {
                        cnt++;
                    } else {
                        break;
                    }
                }
                if (cnt > 1) {
                    sb.append(cnt).append(a);
                } else {
                    sb.append(a);
                }

                j += cnt * i - 1;
            }
            int val = s.length() / i;
            sb.append(s.substring(i * val, s.length()));
            min = Math.min(min, sb.length());

        }

        answer = min;
        return answer;
    }
}