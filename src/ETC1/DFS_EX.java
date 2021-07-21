package ETC1;

import java.util.Scanner;

public class DFS_EX {
    static int pick;
    static char arr[] = {'a', 'b', 'c', 'd', 'e'};
    static char copy[];
    static boolean check[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        pick = sc.nextInt();
        copy = new char[5];
        check = new boolean[5];
        comb(0, 0);
    }// end of main

    private static void comb(int num, int depth) {
        if (depth == pick) {
            for (int i = 0; i < pick; i++) {
                System.out.print(copy[i] + " ");
            }
            System.out.println();
        }
        for (int i = num; i < arr.length; i++) {
            copy[depth] = arr[i];
            comb(i + 1, depth + 1);
        }
    }
} // end of main
