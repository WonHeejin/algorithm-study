import java.util.stream.*;
import java.util.Arrays;
class Solution {
    public int[] solution(String my_string) {
        int[] numbers = my_string.chars() // (IntStream)
        .filter(i -> i>=48&&i<=57)
        .toArray();
        int[] answer = new int[numbers.length];
        for(int i=0; i<numbers.length;i++) {
            answer[i] = numbers[i]-48;
        }
        Arrays.sort(answer);
        return answer;
    }
}