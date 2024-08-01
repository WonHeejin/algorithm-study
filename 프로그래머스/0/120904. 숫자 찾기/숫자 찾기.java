/*
k가 여러 개 있을 경우 가장 처음 자리를 return 해야 하기 때문에 순서대로 검색해야 함.
->원하는 키값을 갖는 요소를 만날 때까지 맨 앞부터 순서대로 검색
=> 선형 검색(=순차 검색)
*/
class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        int[] numArr = new int[Integer.toString(num).length()];
        int cnt = 0;
        //num을 자릿수로 잘라서 배열에 담기
        for(int i=numArr.length-1; i>=0; i--) {
            numArr[i] = num%10;
            num/=10;
        }
        
        while(true) {
            if(cnt == numArr.length) 
                return -1; //일치하는 값 없음
            if(numArr[cnt] == k) 
                return cnt+1; //배열순서는 0부터 시작하므로 +1처리 후 return
            cnt++;
            
        }
    }
}