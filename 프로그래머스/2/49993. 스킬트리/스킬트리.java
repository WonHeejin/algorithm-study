class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int index = 0;
        for(int j=0; j<skill_trees.length; j++) {
            for (int i=0; i<skill_trees[j].length(); i++){
                //스킬 순서에 존재하면 검사
                if(skill.indexOf(skill_trees[j].charAt(i)) != -1) {
                    if(skill.charAt(index) == skill_trees[j].charAt(i)) {
                        index++; //다음 문자 검사
                    } else {
                        break; //skill_trees[j] 검사 종료. 다음 검사로 넘어감.
                    }
                }
                if(i == skill_trees[j].length()-1) { //가능한 스킬트리일 경우
                    answer ++;
                }   
            }    
            index = 0;
        }
        
        return answer;
    }
}