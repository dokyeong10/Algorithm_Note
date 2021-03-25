package JUNGOL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Temp implements Comparable<Temp> {
	int lowtmp;
	int hightmp;

	@Override
	public int compareTo(Temp o) {
		return hightmp - o.hightmp;
	}
}

public class Main_정올_1828_냉장고_오도경 {
	public static void main(String[] args) throws IOException {

		ArrayList<Temp> list = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 개수

		for (int i = 0; i < N; i++) { // 화학 물질 온도 저장
			Temp t = new Temp();
			t.lowtmp = sc.nextInt();
			t.hightmp = sc.nextInt();
			list.add(t);
		} ////////저장 완료 /////////
		
		Collections.sort(list); //오름차순 정렬 

		int low = list.get(0).lowtmp;
		int high = list.get(0).hightmp;
		int cnt = 1; // 냉장고 개수 ( 꼭 하나는 있어야함)
		
		while (true) {
			if (list.size() == 1) {
				break;
			}
			if (list.get(1) != null) {
				if (list.get(1).lowtmp <= high) {
					list.remove(list.get(1));
					continue;
				}
				if (list.get(1).lowtmp > high) {
					low = list.get(1).lowtmp;
					high = list.get(1).hightmp;
					cnt++;
					list.remove(list.get(0));
					continue;
				}
			}
			break;
		}
		System.out.println(cnt);

	}
}
