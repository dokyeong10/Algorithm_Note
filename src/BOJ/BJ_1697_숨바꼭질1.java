package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1697_숨바꼭질1 {

    static int subin, sister;
    static int map[]= new int[100001]; // 범위가 <=100000 이다

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        subin = sc.nextInt();
        sister = sc.nextInt();
        bfs();
    }// end of main

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(subin);
        map[subin] = 1;

        while (!q.isEmpty()) {
            subin = q.poll();
            if (subin == sister) {
                break;
            }
            if (subin + 1 <= 100000 && map[subin + 1] == 0) {
                q.offer(subin + 1);
                map[subin + 1] = map[subin] + 1;
            }
            if (subin - 1 >= 0 && map[subin - 1] == 0) {
                q.offer(subin - 1);
                map[subin - 1] = map[subin] + 1;
            }

            if (subin * 2 <= 100000 && map[subin * 2] == 0) {
                q.offer(subin * 2);
                map[subin * 2] = map[subin] + 1;
            }
        }
        System.out.println(map[sister] - 1); // 처음에 1로 시작해서 1빼줌
    }
}  // end of class
