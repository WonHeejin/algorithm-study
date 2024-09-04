import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> history = new HashSet<>(); //중복값 허용 안함
        char lastChar = words[0].charAt(words[0].length()-1);
        history.add(words[0]);
        
        for(int i=1; i<words.length; i++) {
            history.add(words[i]);
            //앞 단어의 마지막 문자와 다른 경우 || 기존에 언급된 경우
            if(lastChar != words[i].charAt(0)
              || history.size() != i+1) {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            }
            lastChar = words[i].charAt(words[i].length()-1);
        }
        
        return answer;
    }
}