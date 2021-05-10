package BOJ;

import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1158_요세푸스문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb =new StringBuilder();
        sb.append("<");

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        } //    큐에 넣기
      while(N-->1) {
          for (int i = 1; i < K; i++) {
              int temp = q.poll();
              q.offer(temp);
          }
          int cur = 0;
          cur = q.poll();
          sb.append(cur + ", ");
      }
      int last=q.poll();
      sb.append(last+">");
        System.out.println(sb);

    }// end of main

}// end of class
