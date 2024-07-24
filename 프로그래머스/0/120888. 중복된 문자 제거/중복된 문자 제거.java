import java.util.Arrays;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] arrString = Arrays.stream(my_string.split("")).distinct().toArray(String[]::new);
        for(String s : arrString){
            answer+=s;
        }
        
        return answer;
    }
}