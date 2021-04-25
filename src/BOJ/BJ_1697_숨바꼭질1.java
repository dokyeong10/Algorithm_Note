package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1697_숨바꼭질1 {

    static int subin, sister, cnt = 0;
    static int map[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        subin = sc.nextInt();
        sister = sc.nextInt();
        map = new int[100001];

        bfs();
        System.out.println(map[sister]);


    }// end of main

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(subin);

        while (!q.isEmpty()) {
            subin = q.poll();
            if (subin == sister) {
                break;
            }
            if (subin - 1 >= 0 && map[subin - 1] == 0) {
                q.offer(subin - 1);
                map[subin - 1] = map[subin] + 1;

            }
            if (subin + 1 <= 100000 && map[subin + 1] == 0) {
                q.offer(subin + 1);
                map[subin - 1] = map[subin] + 1;
            }
            if (subin * 2 <= 100000 && map[subin * 2] == 0) {
                q.offer(subin * 2);
                map[subin * 2] = map[subin] + 1;
            }


        }


    }
}  // end of class
