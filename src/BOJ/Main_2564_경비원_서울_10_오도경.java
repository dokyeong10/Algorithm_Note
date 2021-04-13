package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2564_경비원_서울_10_오도경 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int width = Integer.parseInt(st.nextToken()); // 가로
        int height = Integer.parseInt(st.nextToken()); // 세로
        int store = Integer.parseInt(br.readLine()); // 상점 수
        int[] point = new int[store + 1];

        for (int i = 0; i <= store; i++) { // 1-북, 2-남, 3-서, 4-동
            st = new StringTokenizer(br.readLine(), " ");
            int dir = Integer.parseInt(st.nextToken()); //방향
            int loc = Integer.parseInt(st.nextToken()); // 위치

            switch (dir) {
                case 1:
                    point[i] = loc;
                    break;
                case 2:
                    point[i] = 2 * width + height - loc;
                    break;
                case 3:
                    point[i] = 2 * (width + height) - loc;
                    break;
                case 4:
                    point[i] = width + loc;
                    break;
            }
        }

        int sum = 0;
        for (int i = 0; i < store; i++) {
            int temp = Math.abs(point[store] - point[i]);
            sum += (temp > (width + height)) ? 2 * (width + height) - temp : temp;

        }
        System.out.println(sum);


    }// end of main
} // end of class
