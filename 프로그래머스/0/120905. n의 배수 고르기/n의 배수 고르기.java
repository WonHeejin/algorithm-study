import java.util.Arrays;
class Solution {
    public int[] solution(int n, int[] numlist) {
        int[] answer = Arrays.stream(numlist) //array->stream
            .filter(i->i%n==0) //n으로 나눴을때 나머지가 0인것만 필터링
            .toArray(); //stream->array
        
        return answer;
    }
}