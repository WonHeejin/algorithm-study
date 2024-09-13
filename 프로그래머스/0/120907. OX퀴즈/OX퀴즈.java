import java.util.StringTokenizer;
class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i=0; i<quiz.length; i++){
            StringTokenizer st = new StringTokenizer(quiz[i]);
            int a = Integer.parseInt(st.nextToken());
            String operator = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            String equal = st.nextToken();
            int result = Integer.parseInt(st.nextToken());
            
            switch(operator) {
                    case "+":
                    answer[i] = a+b == result? "O" : "X";
                    break;
                case "-":
                    answer[i] = a-b == result? "O" : "X";
                    break;
            }
        }
        
        return answer;
    }
}