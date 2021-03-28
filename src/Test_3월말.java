import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test_3월말 {

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 1, 8};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr); //오름차순
        System.out.println(Arrays.toString(arr));

        String[] srr = {"xds", "atr", "dsj", "ppp"};
        System.out.println(Arrays.toString(srr));
        Arrays.sort(srr);
        System.out.println(Arrays.toString(srr));

        A[] aarr = {new A("xx", 7), new A("abc", 9), new A("bbb", 5), new A("ttt", 6)};
        System.out.println(Arrays.toString(aarr));
        Arrays.sort(aarr);
        System.out.println(Arrays.toString(aarr));

    } // end of main

    static class A implements Comparable<A> {
        String s;
        int i;

        public A(String s, int i) {
            this.s = s;
            this.i = i;
        }

        @Override
        public String toString() {
            return "{" + s + " , " +
                    i +
                    '}';
        }

        @Override
        public int compareTo(A o) { //비교기준을 정하기렬
            return this.i - o.i; //오름차순 숫자 기준
            // return this.s.compareTo(o.s); //d오름차순 정렬 문자기준
            //  return o.s.compareTo(this.s); //내림 차순 정 문자기준
        }
    }

}// end of class
