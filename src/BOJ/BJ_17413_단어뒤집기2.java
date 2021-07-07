package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_17413_단어뒤집기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine() + " ");
        StringBuilder result = new StringBuilder();
        StringBuilder verse = new StringBuilder();
        ArrayList<Character> list = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == '<') {
                result.append(sb.charAt(i));
                flag = true;
            } else if (sb.charAt(i) == '>') {
                result.append(sb.charAt(i));
                flag = false;
            } else if (sb.charAt(i) == ' ') {
                result.append(' ');
            } else {
                if (flag) {
                    result.append(sb.charAt(i));
                } else {
                    verse.append(sb.charAt(i));
                    if (i < sb.length() - 1 && (sb.charAt(i + 1) == ' ' || sb.charAt(i + 1) == '<' || i == sb.length())) {
                        verse.reverse();
                        result.append(verse);
                        verse.setLength(0);
                    }
                }
            }
        }
        System.out.println(result);
    } // end of main
} // end of class
