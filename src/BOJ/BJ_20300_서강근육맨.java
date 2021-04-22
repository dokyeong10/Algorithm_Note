package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_20300_서강근육맨 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine()); // 운동기구 개수
        long sports[] = new long[(int) N];
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {

            sports[i] = Integer.parseInt(st.nextToken());
        } // 입력 받기 완료

        long result = 0;
        long k =0;
        long sum=0;
        Arrays.sort(sports);
        if (N % 2 == 0) { //짝수이면
             k = N - 1;
            for (long i = 0; i < N / 2; i++) {

                 sum = sports[(int) i] + sports[(int) k];
                k--;
                result = Math.max(result, sum);
            }
        } else { // 홀수면
             k = N - 2;
            for (long i = 0; i < (N - 1) / 2; i++) {

                sum = sports[(int) i] + sports[(int) k];
                k--;
                result = Math.max(result, sum);
            }
            result = Math.max(result, sports[(int) (N - 1)]);
        }

        System.out.println(result);
//        for (int i = 0; i < N; i++) {
//            System.out.print(sports[i]+" ");
//        }


    } // end of main
} // end of class
