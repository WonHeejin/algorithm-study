class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] arrS = s.split(" ");
        for(int i=0; i<arrS.length; i++){
            if(arrS[i].equals("Z")) {
                answer -= Integer.parseInt(arrS[i-1]);
            } else {
                answer += Integer.parseInt(arrS[i]);
            }
        }
        return answer;
    }
}