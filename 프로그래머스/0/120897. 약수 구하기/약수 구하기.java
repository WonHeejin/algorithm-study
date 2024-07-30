import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<Integer>();
        //약수는 대칭을 이루기 때문에 제곱근 만큼만 반복
        for(int i=1; i<=Math.sqrt(n); i++) {
            if(n%i == 0) {
                list.add(i);
                if(n/i!=i) list.add(n/i); //같은 수가 중복되지 않도록 예외처리
            }
        }
        //list -> array 변환
        int[] answer = list.stream().mapToInt(e->e).toArray();
        //오름차순 정렬
        Arrays.sort(answer);
        return answer;
    }
}