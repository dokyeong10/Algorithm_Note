package SWEA;

import java.io.IOException;
import java.util.Scanner;

public class Solution_SWEA_5607_조합 {
    public static int TC = 0, N, R;
    public static int Q = 1234567891;

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        TC = sc.nextInt();
        for (int test_case = 1; test_case <= TC; test_case++) {
            N = sc.nextInt();
            R = sc.nextInt();
            System.out.printf("#%d %d\n", test_case, nCr(N, R, Q));
        }
    }

    static long power(long x, long y, long p) {
        long res = 1L;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }

    static long mod(long n, long p) {
        return power(n, p - 2, p);
    }

    static long nCr(int n, int r, int p) {
        if (r == 0)
            return 1L;

        long[] fac = new long[n + 1];
        fac[0] = 1;

        for (int i = 1; i <= n; i++)
            fac[i] = fac[i - 1] * i % p;

        return (fac[n] * power(fac[r], p - 2, p)
                % p * power(fac[n - r], p - 2, p)
                % p) % p;
    }
}
