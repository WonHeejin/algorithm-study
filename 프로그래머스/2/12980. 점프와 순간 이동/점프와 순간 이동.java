import java.util.*;

public class Solution {
    public int solution(int n) {
        //도착지로부터 계산 -> 짝수일 땐 순간이동, 홀수일 땐 1칸 점프
        //bitCount : 주어진 정수를 2진법으로 표현했을 때 1의 갯수 반환
        return Integer.bitCount(n);
    }
}