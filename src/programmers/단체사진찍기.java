package programmers;

public class 단체사진찍기 {
    static char arr[] = {'a', 'b', 'c', 'd'};
    static char arrr[];
    static boolean check[];

    public static void main(String[] args) {
        arrr = new char[arr.length];
        check = new boolean[arr.length];

        permutation(0);

    } // end of main

    private static void permutation(int num) {
        if (num == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arrr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!check[i]) {
                arrr[num] = arr[i];
                check[i] = true;
                permutation(num + 1);
                check[i] = false;
            }

        }

    }


} // end of class
