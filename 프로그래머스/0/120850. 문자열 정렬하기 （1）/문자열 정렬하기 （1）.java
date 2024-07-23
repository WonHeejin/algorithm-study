import java.util.stream.*;
import java.util.Arrays;
class Solution {
    public int[] solution(String my_string) {
        String[] numbers = my_string.replaceAll("[^0-9]","") //숫자를 제외한 모든 문자 제거
            .split("");
       int[] answer = Arrays.stream(numbers) //stream으로 변환
            .sorted() //오름차순으로 정렬
            .mapToInt(Integer::parseInt) //int로 변환
            .toArray(); //배열로 변환
        return answer;
    }
}