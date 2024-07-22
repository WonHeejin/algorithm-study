class Solution {
    public int solution(int n) {
        int answer = 1;
        long result = 1;
        while(result*answer<n) {
            answer++;
            result=result*answer;  
        }
        return answer;
    }
}