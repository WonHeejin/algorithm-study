import java.util.stream.IntStream;
class Solution {
    public int[] solution(int n) {
        int[] answer = IntStream.rangeClosed(1, n)
            .filter(i->n%i==0)
            .sorted()
            .toArray();
        return answer;
    }
}