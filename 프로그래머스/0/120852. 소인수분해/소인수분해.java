import java.util.stream.*;
class Solution {
    public int[] solution(int n) {
        int[] answer = IntStream.rangeClosed(2, n)
            .filter(i -> !((int)IntStream.rangeClosed(1, i) //소수구하기
                    .filter(i2 -> i % i2 == 0).count() >2))
            .filter(i -> n%i == 0) //소수 중 n의 약수인 숫자
            .toArray();
        return answer;
        
    }
}