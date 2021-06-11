package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ_12904_A와B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        ArrayList<Character> listS = new ArrayList<>();
        ArrayList<Character> listT = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            listS.add(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            listT.add(t.charAt(i));
        }
        int tmp = t.length();
        while (listS.size() != listT.size()) {
            if (listT.get(tmp - 1) == 'A') {
                listT.remove(tmp - 1);
            } else if (listT.get(tmp - 1) == 'B') {
                listT.remove(tmp - 1);
                Collections.reverse(listT);
            }
            tmp--;
        }
        if (listS.equals(listT)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    } // end of main
} // end of class
