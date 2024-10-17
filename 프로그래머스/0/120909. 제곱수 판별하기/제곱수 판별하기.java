class Solution {
    public int solution(int n) {
        int answer = 0;
        int sqrt = (int) Math.floor(Math.sqrt(n));
        if(n%sqrt == 0) {
            answer = 1;
        } else {
            answer = 2;
        }
        
        return answer;
    }
}