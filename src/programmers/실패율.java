package programmers;

import java.util.*;
import java.io.*;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int student = stages.length;
        Arrays.sort(stages);
        ArrayList<Game> list = new ArrayList<>();

        double[] rate = new double[N + 1];
        double[] fail = new double[N + 1];
        for (int i = student - 1; i >= 0; i--) {
            rate[stages[i] - 1]++;
        }

        double tmp = 0;
        for (int i = 0; i < N; i++) {
            if (rate[i] == 0) {
                tmp = 0;
            } else {
                tmp = rate[i] / student;
                student -= rate[i];
            }
            list.add(new Game(i + 1, tmp));
        }

        Collections.sort(list, new Comparator<Game>() {
            @Override
            public int compare(Game g1, Game g2) {
                if (g1.failrate == g2.failrate) {
                    if (g1.num < g2.num) return -1;
                    else return 1;
                }
                if (g1.failrate < g2.failrate) return 1;
                else return -1;
            }
        });

        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).num;
        }
        return answer;
    }

    static class Game {
        int num;
        double failrate;

        public Game(int num, double failrate) {
            this.num = num;
            this.failrate = failrate;
        }
    }
}
