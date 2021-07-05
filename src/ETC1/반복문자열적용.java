package ETC1;
import java.util.*;
/*
* 문제 설명
* 입력 ["abcxydsaxyabc"]
* 출력 ["abc","xy","dsa","xy","abc"]
*
* or
* 입력 ["asdf"]
* 출력 ["asdf"]
*
* 최대 개수 조각으로 쪼개서 출력하라
* */
public class 반복문자열적용 {
    public String[] solution(String s) {
        ArrayList<String>list = new ArrayList<>();
        String start="";
        String end ="";
        int slice= 1;
        int point=0;
        while(slice<s.length()){
            start= s.substring(0,slice);
            end = s.substring(s.length()-slice,s.length());
            if(start.equals(end)){
                list.add(0+point,start);
                list.add(list.size()-point,end);
                start="";
                end="";
                s= s.substring(slice,s.length()-slice);
                slice=1;
                point++;
            }else{
                slice++;
            }
        }
        if(s.length()>=1){
            list.add(list.size()/2,s);
        }
        String[] answer;
        if(list.size()>0){
            answer = new String[list.size()];
            for(int i=0;i<list.size();i++){
                answer[i]= list.get(i);
            }
        }else{
            answer = new String[1];
            answer[0]= s;
        }
        return answer;
    }

}
