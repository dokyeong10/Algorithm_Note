package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BJ_12026_BOJ거리 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        //k칸만큼 점프를 하는데 필요한 에너지의 양 k*k
        char map[] = new char[str.length()];
        for (int i = 0; i < str.length(); i++)
            map[i] = str.charAt(i);
        //end of input
        //dp
        int dp[] = new int[str.length()];
        for (int i = 0; i < str.length(); i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for (int i = 1; i < str.length(); i++) {
            char a = map[i]; //이동할 곳에 있는 것은 a
            for (int j = 0; j < i; j++) {
                if (a == 'B' && map[j] == 'J') {
                    if (dp[j] == Integer.MAX_VALUE) continue;
                    dp[i] = Math.min(dp[i], (i - j) * (i - j) + dp[j]);
                } else if (a == 'O' && map[j] == 'B') {
                    if (dp[j] == Integer.MAX_VALUE) continue;
                    dp[i] = Math.min(dp[i], (i - j) * (i - j) + dp[j]);
                } else if (a == 'J' && map[j] == 'O') {
                    if (dp[j] == Integer.MAX_VALUE) continue;
                    dp[i] = Math.min(dp[i], (i - j) * (i - j) + dp[j]);
                }
            }
        }
        int result = dp[str.length() - 1];
        if (result == Integer.MAX_VALUE) result = -1;
        System.out.println(result);

    }

} // end of class
