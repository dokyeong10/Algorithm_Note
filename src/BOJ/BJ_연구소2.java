package BOJ;

import java.util.LinkedList;
import java.util.Queue;

public class BJ_연구소2 {
    public static void main(String[] args) {
        String s ="abdbdb";
        System.out.println(s.substring(1,5));
        Queue<Point>q = new LinkedList<>();

    }

    static class Point{
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
