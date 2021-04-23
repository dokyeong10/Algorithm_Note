package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5607_조합_2 {
    private static int p;

    public static void main(String[] args) throws IOException {
        p = 1234567891; //소수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int [][]input =new int[TC+1][2]; //0번은 안씀
        int maxN =0;
        for (int test_case = 1; test_case <= TC; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            input[test_case][0] = Integer.parseInt(st.nextToken());
            input[test_case][1] = Integer.parseInt(st.nextToken());
            if (maxN < input[test_case][0]) maxN = input[test_case][0];
        }
            long[] fact = new long[maxN + 1];
            fact[0] = fact[1] = 1; //0팩토리얼은 1
            for (int i = 2; i < fact.length; i++) {
                fact[i] =  fact[i - 1] * i % p;
            }
            //nCr %p = n!%p * (n-r)^(p-2)%p* (r!)^(p-2)%p
            //nCr %p = n!%p * ((n-r)*(r!))^(p-2)%p
        for (int test_case = 1; test_case <=TC ; test_case++) {


        long result = fact[input[test_case][0]]*power(fact[input[test_case][0] - input[test_case][1]] * fact[input[test_case][1]] % p, p - 2) % p;
            sb.append("#").append(test_case).append(' ').append(result).append('\n');
        }// end of for testcase
        System.out.println(sb);


    }// end of main

    /**
     * Divide & Conquer 거듭제곱 구하기
     */
    public static long power(long base, long ex) {
        if (ex == 0) { //기저조건
            return 1;

        }
        if (ex == 1) { //기저조건
            return base;
        } else if (ex % 2 == 0) { // 짝수 홀수 구분해서 구현 ((짝수))
            long result = power(base, ex / 2);
            return result * result % p;

        } else { //((홀수))
            long result = power(base, ex / 2);
            return result * result % p * base % p;

        }


    }


}// end of class
