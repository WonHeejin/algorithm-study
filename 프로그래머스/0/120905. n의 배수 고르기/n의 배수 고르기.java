/*for문으로 배열 생성해서 값 넣기
stream과 성능 비교
*/
class Solution {
    public int[] solution(int n, int[] numlist) {
        int count = 0;
        int index = 0;
        for(int x: numlist) {
            if(x%n==0)
                count++;
        }
        
        int[] answer = new int[count];
        
        for(int a: numlist) {
            if(a%n==0) {
                answer[index] = a;
                index++;
            }
            if(index==count) break;
        }
        return answer;
    }
}