package ETC1;
import java.util.*;
public class 숫자문자열과영단어_좋은코드 {
    public int solution(String s) {
        int answer = 0;
        String number[] ={"0","1","2","3","4","5","6","7","8","9"};
        String alphabet[]={"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i=0;i<10;i++){
            s= s.replaceAll(alphabet[i],number[i]);
        }
        return Integer.parseInt(s);
    }
}
