package programmers;
import java.util.*;
public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int [2];
        int num=0; //누가 걸렸는지
        int cnt=0; // 돌고 있는 횟수
        for(int i=0; i<words.length; i++){
            if(i%n==0) cnt++;
            if((i+1)%n!=0){
                num =(i+1)%n;
            }else{ //마지막번호
                num = n;
            }
            if(i!=0&&(words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0))){
                answer[0]=num;
                answer[1]=cnt;
                return answer;
            }
            for(int j=0; j<i; j++){
                if(words[i].equals(words[j])){
                    answer[0]=num;
                    answer[1]=cnt;
                    return answer;
                }
            }
        }
        answer[0]=0;
        answer[1]=0;
        return answer;
    }
}
