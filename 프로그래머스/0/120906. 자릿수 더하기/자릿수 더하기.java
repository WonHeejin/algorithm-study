/*java에서는 꼬리 재귀 최적화를 지원하지 않음 -> 반복문으로 수정*/
class Solution {
    public int solution(int n) {
        int answer = 0;
        while(n>0) {
            answer+=n%10;
            n/=10;
        }
        return answer;
    }
}
