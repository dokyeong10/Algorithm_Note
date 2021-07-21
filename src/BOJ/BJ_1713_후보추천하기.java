package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ_1713_후보추천하기 {
    static int N, M;
    static int[] students;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 사진틀 개수
        M = sc.nextInt(); // 추천하는 수
        students = new int[101]; //학생 번호 100번

        ArrayList<Student> list = new ArrayList<Student>();

        for (int i = 0; i < M; i++) {
            int student = sc.nextInt();
            if (students[student] > 0) {
                students[student] += 1;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).num == student) {
                        list.get(j).total += 1;
                        break;
                    }
                }
            } else {
                if (list.size() >= N) {
                    Collections.sort(list);
                    int num = list.get(0).num;
                    students[num] = 0;
                    list.remove(0);
                }
                list.add(new Student(student, 1, i));
                students[student] = 1;
            }
        }
        for (int i = 0; i < 101; i++) {
            if (students[i] != 0) {
                System.out.print(i + " ");
            }
        }
    }

    static class Student implements Comparable<Student> {
        int num;
        int total;
        int time;

        public Student(int num, int total, int time) {
            this.num = num;
            this.total = total;
            this.time = time;
        }

        @Override
        public int compareTo(Student o) {
            if (this.total == o.total) {
                return this.time - o.time;
            } else if (this.total < o.total)
                return -1;
            else return 1;
        }

    } // end of main

}// end of class

