package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_2164_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		Queue<Integer> qu = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			qu.offer(i);
		}
		while (qu.size() != 1) {
			int first = qu.poll();
			int second = qu.poll();
			qu.offer(second);

		}
		System.out.println(qu.poll());
		sc.close();
	}

}
