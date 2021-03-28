package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class BJ_2751_수정렳하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();

        int N =Integer.parseInt(br.readLine());
        int arr[]=new int[N];

        ArrayList<Integer>list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for (int value: list) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    } // end of main
}// end of class
