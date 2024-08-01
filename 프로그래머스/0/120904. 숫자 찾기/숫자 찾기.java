/*
k가 여러 개 있을 경우 가장 처음 자리를 return 해야 하기 때문에 순서대로 검색해야 함.
->원하는 키값을 갖는 요소를 만날 때까지 맨 앞부터 순서대로 검색
=> 선형 검색(=순차 검색)
+) 보초법 이용해서 종료 조건 판단 비용 줄이기
보초법 : 배열 맨 끝 요소에 키값을 저장해 종료조건을 하나로 줄이는 방법.
*/
class Solution {
    public int solution(int num, int k) {
        int answer = 0, cnt = 0;
        int[] numArr = new int[Integer.toString(num).length()+1]; //보초를 저장하기 위해 배열 길이를 자릿수+1로 초기화
        
        numArr[numArr.length-1] = k; //마지막 요소에 보초 저장
        
        //num을 자릿수로 잘라서 배열에 담기
        for(int i=numArr.length-2; i>=0; i--) {
            numArr[i] = num%10;
            num/=10;
        }
        
        while(true) {
            if(numArr[cnt] == k) 
                return cnt==numArr.length-1?-1:cnt+1; //배열순서는 0부터 시작하므로 +1처리 후 return
            cnt++;
            
        }
    }
}
