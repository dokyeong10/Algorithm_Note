package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_18258_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Deque<Integer> q = new LinkedList<>();
        while (N-- > 0) {

             st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {

                case "push":
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    Integer cur = q.poll();
                    if (cur == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(cur).append('\n');
                    }
                    break;

                case "size":
                    sb.append(q.size()).append('\n');
                    break;

                case "empty":
                    if (!q.isEmpty()) {
                       sb.append(0).append('\n');
                    } else {
                        sb.append(1).append('\n');
                    }
                    break;

                case "front" :
                    Integer pe = q.peek();
                    if(pe == null){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(pe).append('\n');
                    }
                    break;
                case "back":
                    Integer ba = q.peekLast();
                    if(ba == null){
                        sb.append(-1).append('\n');
                    }else {
                        sb.append(ba).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);

    } // end of main
} // end of class
