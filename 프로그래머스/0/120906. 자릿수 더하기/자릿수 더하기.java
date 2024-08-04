class Solution {
    public int solution(int n) {
        int answer = 0;
        
        return cal(n, answer);
    }
    
    public int cal(int n, int answer) {
        answer+=n%10;
        n/=10;
        return n==0?answer:cal(n, answer);
    }
}