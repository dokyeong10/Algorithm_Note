package BOJ;

import java.util.Scanner;

public class Main_16953_AB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int cnt = 1;

        while (A < B) {
            if (B % 2 == 0) {
                B = B / 2;
            } else if (B % 10 == 1) {
                B = (B - 1) / 10;
            } else {
                B = -1;
                break;
            }
            cnt++;
        }
        if (A > B) {
            System.out.println(-1);
            return;
        }
        System.out.println(cnt);

    }
}
