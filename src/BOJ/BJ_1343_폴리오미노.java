package BOJ;

import java.util.Scanner;

public class BJ_1343_폴리오미노 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] X = new char[s.length()];
        int cnt = 0;
        String result = "";
        if (s.equals("X")) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            X[i] = s.charAt(i);
            if (X[i] == 'X') {
                cnt++;
                if (i == s.length() - 1) {
                    while (cnt > 0) {
                        if (cnt >= 4) {
                            result += "AAAA";
                            cnt -= 4;
                        } else {
                            result += "BB";
                            cnt -= 2;
                        }
                    }
                }
            } else if (X[i] == '.' && cnt % 2 != 0) {
                System.out.println(-1);
                return;
            } else if (X[i] == '.' && cnt == 0) {
                result += ".";
                cnt = 0;
            } else if (X[i] == '.' && cnt % 2 == 0) {
                while (cnt > 0) {
                    if (cnt >= 4) {
                        result += "AAAA";
                        cnt -= 4;
                        if (cnt == 0) {
                            result += '.';
                        }
                    } else {
                        result += "BB";
                        cnt -= 2;
                        if (cnt == 0) {
                            result += '.';
                        }
                    }
                }
            }
        }
        if (cnt != 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    } // end of main
} // end of class
