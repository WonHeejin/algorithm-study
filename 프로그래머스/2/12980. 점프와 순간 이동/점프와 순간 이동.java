import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        //도착지로부터 계산 -> 짝수일 땐 순간이동, 홀수일 땐 1칸 점프
        while(n>2) {
            if(n%2==1) {
                n-=1;
                ans++;
            }
                n/=2;
        }
        //n==2 -> 1칸 앞으로 점프 후 순간이동 -> ans++;
        ans++;

        return ans;
    }
}