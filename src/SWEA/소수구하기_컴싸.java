package SWEA;

public class 소수구하기_컴싸 {
    public static void main(String[] args) {
        int P = 1234567891; //소수라면, 약수 1과 자기자신 뿐

        boolean flag = true; //소수
        for (int i = 2; i < P; i++) {
            if (P % i == 0) {
                flag = false; //소수 아님
                break;
            }
        }
        System.out.println(flag ? "소수" : "소수아님(합성수");
    }// end of main
} // end of class
