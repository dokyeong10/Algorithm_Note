package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2846_오르막길 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int road[] = new int[N];

        for (int i = 0; i < N; i++) {
            road[i] = sc.nextInt();
        }
        int result = 0;
        int arr[] = new int[N];
        int k = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (road[i] < road[(i + 1) % N]) {
                arr[k] = road[i];
                arr[k + 1] = road[(i + 1) % N];
                k++;
            } else {
                result = arr[k] - arr[0];
                max = Math.max(result, max);
                Arrays.fill(arr, 0);
                k = 0;

            }
        }

        System.out.println(max);


    }// end of main
} // end of class
