class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        for(int i=0; i<skill_trees.length; i++) {
            //skill_trees의 문자열에서 skill을 제외한 문자 모두 제거 -> indexOf로 skill문자와 비교
            if(skill.indexOf(skill_trees[i].replaceAll("[^"+skill+"]",""))!=0) {
                answer--; //스킬트리 불가능한 경우 제외
            }
        }
        return answer;
    }
}