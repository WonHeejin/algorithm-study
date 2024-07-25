class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] arrChar = my_string.toCharArray();
        for(int i=0; i<arrChar.length; i++) {
            if(Character.isUpperCase(arrChar[i])) {
                arrChar[i] = Character.toLowerCase(arrChar[i]);
            } else {
                arrChar[i] = Character.toUpperCase(arrChar[i]);
            }
        }
        answer = String.valueOf(arrChar);
        return answer;
    }
}