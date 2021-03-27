package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Main_13706_제곱근 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        int l,r;
        BigInteger one = BigInteger.ONE; // 1
        BigInteger two = new BigInteger("2"); // 2

        BigInteger target = new BigInteger(num); // 입력 문자열 to biginteger

        BigInteger left = BigInteger.ONE; // 1
        BigInteger right = new BigInteger(num); // 입력받는 수

        BigInteger mid, x;

        while (left.compareTo(right) <= 0) { // left랑 right가 서로 반전됨
            mid = (left.add(right)).divide(two); // (left+right)/2
            x = mid.multiply(mid); // mid^2

            int ret = x.compareTo(target); // x와 target 비교
            if (ret == 0) { // 정답을 찾음!
                System.out.println(mid.toString()); // 제곱근 mid 출력
                break; // 탈출
            } else if (ret == -1) { // 타겟보다 x가 작음
                left = mid.add(one);
            } else if (ret == 1) { // 타겟보다 x가 크다
                right = mid.subtract(one);
            }
        }
    }
}
