import java.lang.StringBuilder;
class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        char char1 = my_string.charAt(num1);
        char char2 = my_string.charAt(num2);
        StringBuilder builder = new StringBuilder(my_string);
        builder.setCharAt(num1, char2);
        builder.setCharAt(num2, char1);
        answer = builder.toString();
        return answer;
    }
}