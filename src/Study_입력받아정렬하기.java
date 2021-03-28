import java.util.Arrays;
import java.util.Scanner;

public class Study_입력받아정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        A[] aa = new A[N];
        String s[] = new String[N];
        int rr[] = new int[N];

        for (int i = 0; i < N; i++) {
            s[i] = sc.next();
            rr[i] = sc.nextInt();
            aa[i] = new A(rr[i], s[i]);
        }
        Arrays.sort(aa);

        System.out.println(Arrays.toString(aa));


    } // end of main

    static class A implements Comparable<A> {
        int i;
        String s;

        public A(int i, String s) {
            this.i = i;
            this.s = s;
        }

        @Override
        public String toString() {
            return i + " " + s;
        }

        @Override
        public int compareTo(A o) {
            return this.s.compareTo(o.s);
        }
    }
}
