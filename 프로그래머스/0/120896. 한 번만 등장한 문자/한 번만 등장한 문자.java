import java.util.stream.*;
import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String answer = Arrays.stream(s.split("")) //split("") 으로 문자 단위 String[] 생성 후 stream으로 변환
            .filter(i->countCharacter(s, i.charAt(0)) ==1) //countCharacter의 결과가 1인 것만 걸러냄
            .sorted() //오름차순 정렬
            .collect(Collectors.joining()); //스트림 요소 문자열로 결합
            
        return answer;
    }
    
    //전달받은 문자열(text)의 특정 문자(character) 갯수를 전달
    public long countCharacter(String text, char character) {
        return text.chars() //문자열을 문자단위로 쪼갠 뒤 해당 문자의 아스키코드값을 int로 변환
            .filter(i->i==character) //전달받은 문자의 코드값과 동일한 값만 필터링
            .count(); //갯수 리턴
    }
}