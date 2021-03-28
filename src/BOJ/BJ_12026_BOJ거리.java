package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_12026_BOJ거리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //개수

        String s = sc.next(); //문자열

        char arr[] = new char[N];
        for (int i = 0; i < N; i++) {
            arr[i] = s.charAt(i);
        }
        int cnt = 0, sum = 0;
        arr[0] = 'B';


        for (int i = 1; i < N; i++) {
            if (arr[i - 1] == 'B') {
                if (arr[i] == 'J' || arr[i] == 'B') {
                    cnt++;
                    continue;
                } else {
                    cnt++;
                    sum += cnt * cnt;
                    cnt = 0;

                }
            } else if (arr[i - 1] == 'O') {

                if (arr[i] == 'O' || arr[i] == 'B') {
                    cnt++;
                    continue;
                } else {
                    cnt++;
                    sum += cnt * cnt;
                    cnt = 0;
                }
            } else if (arr[i - 1] == 'J') {

                if (arr[i] == 'O' || arr[i] == 'J') {
                    cnt++;
                    continue;
                } else {
                    cnt++;
                    sum += cnt * cnt;
                    cnt = 0;
                }
            }
        }


    } // end of main
} // end of class
