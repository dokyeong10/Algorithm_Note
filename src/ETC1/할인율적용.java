package ETC1;

import java.util.*;

/*
 * 문제 설명
 * 가격별 상품 , 여러 가격 쿠폰
 * 1상품 1쿠폰 적용 가능
 * 최소 비용 하면 얼마?
 * */
public class 할인율적용 {
    public int solution(int[] prices, int[] discounts) {
        int answer = 0;
        Arrays.sort(prices);
        Arrays.sort(discounts); // 쿠폰
        int tmp = discounts.length - 1;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (tmp > -1) {
                answer += (prices[i] * (100 - discounts[tmp])) * 0.01;
                tmp--;
            } else {
                answer += prices[i];
            }
        }
        return answer;
    }
}
