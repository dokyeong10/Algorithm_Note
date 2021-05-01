package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7573_고기잡이 {
    static int N, M, I, fish[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 모눈종이 크기
        I = Integer.parseInt(st.nextToken()); // 그물 길이
        M = Integer.parseInt(st.nextToken()); // 물고기 수

        fish=new int[N+1][N+1];
        Queue<Point> q=new LinkedList<>();


        for (int i = 0; i < M; i++) {
            st= new StringTokenizer(br.readLine()," ");
            int r =Integer.parseInt(st.nextToken());
            int c =Integer.parseInt(st.nextToken());

            fish[r][c]=100;
            q.offer(new Point(r,c));
        }
        Point cur =q.poll();


    }// end of main
    static class Point{
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
