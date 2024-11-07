class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        //초 단위로 변경
        int video_sec = Integer.parseInt(video_len.split(":")[0])*60+Integer.parseInt(video_len.split(":")[1]);
        int pos_sec = Integer.parseInt(pos.split(":")[0])*60+Integer.parseInt(pos.split(":")[1]);
        int op_start_sec = Integer.parseInt(op_start.split(":")[0])*60+Integer.parseInt(op_start.split(":")[1]);
        int op_end_sec = Integer.parseInt(op_end.split(":")[0])*60+Integer.parseInt(op_end.split(":")[1]);

        //명령어 갯수만큼 반복
        for(int i=0; i<commands.length; i++) {
            pos_sec = checkOpening(op_start_sec, op_end_sec, pos_sec);
            if(commands[i].equals("prev")) {
                pos_sec = Math.max(0, pos_sec-10);
            }else if(commands[i].equals("next")) {
                pos_sec = Math.min(video_sec, pos_sec+10);
            }
        }
        pos_sec = checkOpening(op_start_sec, op_end_sec, pos_sec);
        
        String min = pos_sec/60<10?"0"+pos_sec/60:pos_sec/60+"";
        String sec = pos_sec%60<10?"0"+pos_sec%60:pos_sec%60+"";
        
        return min+ ":" + sec;
    }
    
    public int checkOpening(int op_start_sec, int op_end_sec, int pos) {
        if(pos>=op_start_sec && pos<=op_end_sec) {
            return op_end_sec;
        }
        return pos;
    }
}