import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int start = 0;
        int end = people.length-1;
        //오름차순 정렬
        Arrays.sort(people);

        while(start<=end) {
            //가장 작은 몸무게와 가장 큰 몸무게의 합이 limit이하면 둘 다 구출
            if(people[start]+people[end]<=limit){
                start++;
                end--;
            } else {
                //아니면 가장 큰 몸무게만 구출
                end--;
            }
            answer++;
        }
        
        return answer;
    }
}