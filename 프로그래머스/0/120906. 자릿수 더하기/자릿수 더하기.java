class Solution {
    public int solution(int n) {
        int answer = 0;
        
        return cal(n, answer);
    }
    /*재귀함수는 매개변수, 리턴값, 리턴할 위치가 Stack 메모리에 쌓임-> 함수 호출 횟수가 많아지면 Stack Overflow가 발생할 수 있음.
    함수를 호출하고 종료할때 스택 프레임을 구성하고 해제하면서 반복문보다 오버헤드(over head)가 들기 때문에 속도가 느려짐.
    오버헤드 : 어떤 처리를 하기 위해 들어가는 간접적인 처리 시간/메모리 등.
    꼬리 재귀(tail recursion) : 재귀 호출 이후 추가적인 연산을 하지 않게 하여 컴파일 시 반복문으로 인지하게 함. 이를 통해 재귀함수 최적화가 가능함. 단, 컴파일러가 꼬리 재귀 최적화를 지원해야 함.
    */
    public int cal(int n, int answer) {
        if(n==0) return answer;
        
        answer+=n%10;
        n/=10;
        
        return cal(n, answer);
    }
}