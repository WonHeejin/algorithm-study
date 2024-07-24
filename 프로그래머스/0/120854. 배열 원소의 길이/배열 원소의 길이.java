/*배열에 담긴 데이터 모두에 동일한 작업 반복
 -> stream 활용하는 방법으로 수정*/
import java.util.stream.*;
import java.util.Arrays;
class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = Arrays.stream(strlist) //배열을 stream으로 변환
            .mapToInt(String::length) // String.length 함수에 배열 요소 담은 후 int로 변환
            .toArray(); //배열로 변환
        return answer;
    }
}