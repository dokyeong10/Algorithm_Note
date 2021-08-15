package programmers;

import java.util.*;
import java.io.*;

class 신규아이디추천 { //신규 아이디 추천 추천 추천
    public String solution(String new_id) {
        String answer = "";
        StringBuilder sb = new StringBuilder(new_id.toLowerCase());



        StringBuilder tmp = new StringBuilder(); // empty

        for(int i=0;i<sb.length();i++){
            if((sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z') || sb.charAt(i) == '-' || sb.charAt(i) == '_' || sb.charAt(i) == '.' || (sb.charAt(i) >= '0' && sb.charAt(i) <= '9')){
                tmp.append(sb.charAt(i));
            }
        }
        sb.setLength(0);
        //  System.out.println(sb);


        for(int i=0; i<tmp.length()-1;i++){
            if(tmp.charAt(i)=='.'&&tmp.charAt(i+1)=='.'){
                continue;
            }else{
                sb.append(tmp.charAt(i));
            }
        }
        sb.append(tmp.charAt(tmp.length()-1));

        if(sb.length()>0&&sb.charAt(0)=='.'){
            sb.deleteCharAt(0);
        }
        if(sb.length()>0&&sb.charAt(sb.length()-1)=='.'){
            sb.deleteCharAt(sb.length()-1);
        }

        if(sb.length()==0){
            sb.append('a');
        }

        if(sb.length()>=16){
            sb.delete(15,sb.length());
            if(sb.charAt(14)=='.'){
                sb.deleteCharAt(14);
            }
        }
        while(sb.length()<3)
        {
            sb.append(sb.charAt(sb.length()-1));
        }


        System.out.println(sb);
        answer =sb.toString();



        return answer;
    }
}