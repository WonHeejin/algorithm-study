class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int number = 0, index = 0;
        
        for(int i=0; i<array.length; i++) {
            if(array[i]>number) {
                number = array[i];
                index = i;
            }
        }
        answer[0] = number;
        answer[1] = index;
        return answer;
    }
}