import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Deque<String> deque = new ArrayDeque<>();
        deque.add(words[0]);
        
        for(int i=1; i<words.length; i++) {
            String latest = deque.getLast();
            //앞 단어의 마지막 문자와 다른 경우 || 기존에 언급된 경우
            if(latest.charAt(latest.length()-1) != words[i].charAt(0)
              || deque.contains(words[i])) {
                i++;
                answer[0] = i%n == 0? n : i%n;
                answer[1] = i%n == 0? i/n : i/n+1;
                break;
            }
            deque.addLast(words[i]);
        }
        
        return answer;
    }
}