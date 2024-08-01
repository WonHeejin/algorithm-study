/*string으로 변환하여 indexOf 사용하는 방법으로 변경*/
class Solution {
    public int solution(int num, int k) {
        return ("-"+num).indexOf(String.valueOf(k));
    }
}