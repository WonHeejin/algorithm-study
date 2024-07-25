class Solution {
    public int solution(int[] array, int n) {
        int answer = array[0];
        int abs = Math.abs(array[0] - n);
        for(int i =1; i<array.length; i++) {
            if(Math.abs(array[i]-n)<abs) {
                answer = array[i];
                abs = Math.abs(array[i]-n);
            } else if(Math.abs(array[i]-n) == abs) {
                if(answer > array[i]) { 
                    answer = array[i];
                    abs = Math.abs(array[i]-n);
                }
            }
        }
        return answer;
    }
}